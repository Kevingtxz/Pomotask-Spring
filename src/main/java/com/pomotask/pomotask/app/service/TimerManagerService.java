package com.pomotask.pomotask.app.service;

import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerManagerMapper;
import com.pomotask.pomotask.app.dto.view.TimerManagerView;
import com.pomotask.pomotask.app.repository.TimerManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TimerManagerService extends AbsService<TimerManagerModel, TimerManagerForm, TimerManagerView> {


    @Autowired
    public TimerManagerService(TimerManagerRepository repo, TimerManagerMapper mapper, UserService userService) {
        super(repo, mapper, userService);
    }


    @Override
    protected Set<TimerManagerModel> modelSet(Integer userId) {
        return this.userService.findTimerManagerSetById(userId);
    }

    @Override
    protected String currentClassModelStr() {
        return TimerManagerModel.class.getName();
    }

}
