package com.pomotask.pomotask.main.service;

import com.pomotask.pomotask.auth.auth_user.AuthModel;
import com.pomotask.pomotask.auth.auth_user.AuthService;
import com.pomotask.pomotask.auth.user.UserModel;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.main.domain.AbsModel;
import com.pomotask.pomotask.main.dto.mapper.AbsMapper;
import com.pomotask.pomotask.main.repository.AbsRepository;
import com.pomotask.pomotask.main.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;


@RequiredArgsConstructor
public abstract class AbsService<Model extends AbsModel, Form> {


    final protected AbsRepository<Model> repo;
    final protected AbsMapper mapper;
    final protected UserService userService;


    public Page<Model> findPageByUserEmail(String userEmail, Integer page, Integer linesPerPage) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        return this.repo.findPageByUserAuthEmail(userEmail, pageRequest);
    }

    public Set<Model> findAllByUserEmail(String userEmail) {
        return this.repo.findAllByUserAuthEmail(userEmail);
    }

    public Model findByUserEmailAndId(String userEmail, Integer id) {
        return this.repo.findByUserAuthEmailAndId(userEmail, id)
            .orElseThrow(() -> new ObjectNotFoundException(
                "Object not found. ID:" + id + "."));
    }

    @Transactional
    public void deleteByUserEmailAndId(String userEmail, Integer id) {
        this.repo.deleteByUserAuthEmailAndId(userEmail, id);
    }

    @Transactional
    public Model insert(String userEmail, Form form) {
        UserModel user = this.userService.findByEmail(userEmail);
        Model obj = (Model) this.mapper.toModel(form);
        obj.setUser(user);
        obj = this.repo.save(obj);
        return obj;
    }

    @Transactional
    public void update(String userEmail, Form form, Integer id) {
        UserModel user = this.userService.findByEmail(userEmail);
        Model newObj = (Model) this.mapper.toModel(form);
        Model obj = this.repo.findByUserAuthEmailAndId(userEmail, id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Object not found."));
        try {
            for (PropertyDescriptor pd : Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors())
                if (pd.getReadMethod() != null && pd.getWriteMethod() != null
                        && !"class".equals(pd.getName())
                        && pd.getReadMethod().invoke(newObj) != null)
                    pd.getWriteMethod().invoke(obj, pd.getReadMethod().invoke(newObj));
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        obj.setUser(user);
        this.repo.save(obj);
    }

    protected abstract Set<Model> modelSet(String userEmail);

}