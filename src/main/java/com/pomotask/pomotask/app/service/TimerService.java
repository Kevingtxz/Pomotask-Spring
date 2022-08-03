package com.pomotask.pomotask.app.service;

import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.app.model.TimerModel;
import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerMapper;
import com.pomotask.pomotask.app.dto.view.TimerView;
import com.pomotask.pomotask.app.repository.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TimerService extends AbsService<TimerModel, TimerForm, TimerView> {


    @Autowired
    public TimerService(TimerRepository repo, TimerMapper mapper, UserService userService) {
        super(repo, mapper, userService);
    }


    @Override
    protected Set<TimerModel> modelSet(Integer userId) {
        return this.userService.findTimerSetById(userId);
    }

    @Override
    protected String currentClassModelStr() {
        return TimerModel.class.getName();
    }

}