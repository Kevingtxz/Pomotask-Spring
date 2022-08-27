package com.pomotask.pomotask.app.service.impl;

import com.pomotask.pomotask.auth.user.UserModel;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerMapper;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.model.TimerModel;
import com.pomotask.pomotask.app.repository.TimerRepository;
import com.pomotask.pomotask.app.service.TimerService;
import com.pomotask.pomotask.app.service.exception.ObjectNotFoundException;
import com.pomotask.pomotask.util.enums.RestMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@Slf4j
@Service
public class TimerServiceImpl implements TimerService {


    final private TimerRepository repo;
    final private TimerMapper mapper;
    final private UserService userService;

    @Autowired
    public TimerServiceImpl(TimerRepository repo, TimerMapper mapper, UserService userService) {
        this.repo = repo;
        this.mapper = mapper;
        this.userService = userService;
    }

    public Set<TimerModel> findAllByUserId(Integer userId) {
        return this.userService.findTimerSetById(userId);
    }

    public TimerModel findByUserIdAndId(Integer userId, Integer id) {
        return this.repo.findByUserIdAndId(userId, id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Object class " + TimerModel.class
                                + " not found.  ID:" + id
                                + " USER EMAIL: " + userId + "."));
    }

    @Override
    public TimerModel insert(Integer userId, TimerManagerModel timerManager, TimerForm form) {
        UserModel user = this.userService.findById(userId);
        TimerModel model = this.mapper.toModel(form);
        model.setUser(user);
        model.setTimerManager(timerManager);
        model = this.repo.save(model);
        this.useLog(RestMethod.CREATE, model.getId());
        return model;
    }

    @Transactional
    public void deleteByUserIdAndId(Integer userId, Integer id) {
        TimerModel model = this.findByUserIdAndId(userId, id);
        this.repo.delete(model);
        this.useLog(RestMethod.DELETE, id);
    }

    @Transactional
    public void update(Integer userId, Integer id, TimerForm form) {
        TimerModel model = this.findByUserIdAndId(userId, id);
        TimerModel updateModel = this.mapper.toModel(form);
        try {
            for (PropertyDescriptor pd : Introspector.getBeanInfo(model.getClass()).getPropertyDescriptors())
                if (pd.getReadMethod() != null && pd.getWriteMethod() != null
                        && !"class".equals(pd.getName())
                        && pd.getReadMethod().invoke(updateModel) != null)
                    pd.getWriteMethod().invoke(model, pd.getReadMethod().invoke(updateModel));
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.repo.save(model);
        this.useLog(RestMethod.UPDATE, model.getId());
    }

    private void useLog(RestMethod method, Integer id) {
        this.log.info("Object Class: " + TimerServiceImpl.class
                + ", Action: " + method.getText()
                + ", ITEM_ID: " + id + ".");
    }

}
