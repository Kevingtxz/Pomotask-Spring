package com.pomotask.pomotask.app.service.impl;

import com.pomotask.pomotask.auth.user.UserModel;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerManagerMapper;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.repository.TimerManagerRepository;
import com.pomotask.pomotask.app.service.TimerManagerService;
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
public class TimerManagerServiceImpl implements TimerManagerService {


    final private TimerManagerRepository repo;
    final private TimerManagerMapper mapper;
    final private UserService userService;
    final private TimerService timerService;

    @Autowired
    public TimerManagerServiceImpl(TimerManagerRepository repo, TimerManagerMapper mapper, UserService userService, TimerService timerService) {
        this.repo = repo;
        this.mapper = mapper;
        this.userService = userService;
        this.timerService = timerService;
    }


    @Transactional
    public TimerManagerModel insert(Integer userId, TimerManagerForm form) {
        UserModel user = this.userService.findById(userId);
        TimerManagerModel model = this.mapper.toModel(form);
        model.setUser(user);
        final TimerManagerModel objSaved = this.repo.save(model);
        form.getTimerEntitySet()
                .stream()
                .forEach(obj -> this.timerService.insert(userId, objSaved, obj));
        this.useLog(RestMethod.CREATE, model.getId());
        return objSaved;
    }

    public Set<TimerManagerModel> findAllByUserId(Integer userId) {
        return this.userService.findTimerManagerSetById(userId);
    }

    public TimerManagerModel findByUserIdAndId(Integer userId, Integer id) {
        return this.repo.findByUserIdAndId(userId, id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Object class " + TimerManagerModel.class
                                + " not found.  ID:" + id
                                + " USER EMAIL: " + userId + "."));
    }

    @Transactional
    public void deleteByUserIdAndId(Integer userId, Integer id) {
        TimerManagerModel model = this.findByUserIdAndId(userId, id);
        this.repo.delete(model);
        this.useLog(RestMethod.DELETE, id);
    }

    @Transactional
    public void update(Integer userId, Integer id, TimerManagerForm form) {
        TimerManagerModel model = this.findByUserIdAndId(userId, id);
        TimerManagerModel updateModel = this.mapper.toModel(form);
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
        this.log.info("Object Class: " + TimerManagerServiceImpl.class
                + ", Action: " + method.getText()
                + ", ITEM_ID: " + id + ".");
    }

}
