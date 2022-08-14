package com.pomotask.pomotask.app.service;

import com.pomotask.pomotask.app.dto.form.AbsForm;
import com.pomotask.pomotask.app.dto.mapper.AbsMapper;
import com.pomotask.pomotask.app.dto.view.AbsView;
import com.pomotask.pomotask.app.model.AbsModel;
import com.pomotask.pomotask.app.repository.AbsRepository;
import com.pomotask.pomotask.app.service.exception.ObjectNotFoundException;
import com.pomotask.pomotask.auth.user.UserModel;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.util.enums.RestMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;


@Slf4j
@RequiredArgsConstructor
public abstract class AbsService<
        Model extends AbsModel,
        Form extends AbsForm,
        View extends AbsView> {


    final protected AbsRepository<Model> repo;
    final protected AbsMapper<Model, Form, View> mapper;
    final protected UserService userService;


    public Set<Model> findAllByUserId(Integer userId) {
        return this.modelSet(userId);
    }

    public Model findByUserIdAndId(Integer userId, Integer id) {
        return this.repo.findByUserIdAndId(userId, id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Object not found. ID:" + id +
                                " USER EMAIL: " + userId + "."));
    }

    @Transactional
    public void deleteByUserIdAndId(Integer userId, Integer id) {
        Model obj = this.findByUserIdAndId(userId, id);
        this.repo.delete(obj);
        this.useLog(RestMethod.DELETE, id);
    }

    @Transactional
    public Model insert(Integer userId, Form form) {
        UserModel user = this.userService.findById(userId);
        Model obj = this.mapper.toModel(form);
        obj.setUser(user);
        obj = this.repo.save(obj);
        this.useLog(RestMethod.CREATE, obj.getId());
        return obj;
    }

    @Transactional
    public void update(Integer userId, Form form, Integer id) {
        Model obj = this.findByUserIdAndId(userId, id);
        Model newObj = this.mapper.toModel(form);
        try {
            for (PropertyDescriptor pd : Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors())
                if (pd.getReadMethod() != null && pd.getWriteMethod() != null
                        && !"class".equals(pd.getName())
                        && pd.getReadMethod().invoke(newObj) != null)
                    pd.getWriteMethod().invoke(obj, pd.getReadMethod().invoke(newObj));
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.repo.save(obj);
        this.useLog(RestMethod.UPDATE, obj.getId());
    }

    private void useLog(RestMethod method, Integer id) {
        this.log.info("Object Class: " + this.currentClassModelStr()
                + ", Action: " + method.getText()
                + ", ITEM_ID: " + id + ".");
    }

    protected abstract Set<Model> modelSet(Integer userId);
    protected abstract String currentClassModelStr();

}