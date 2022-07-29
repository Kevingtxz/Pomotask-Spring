package com.pomotask.pomotask.main.service;

import com.pomotask.pomotask.auth.auth_user.AuthService;
import com.pomotask.pomotask.main.domain.TimerModel;
import com.pomotask.pomotask.main.dto.form.TimerForm;
import com.pomotask.pomotask.main.dto.mapper.TimerMapper;
import com.pomotask.pomotask.main.repository.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimerService extends AbsService<TimerModel, TimerForm> {


    @Autowired
    public TimerService(TimerRepository repo, TimerMapper mapper, AuthService authService) {
        super(repo, mapper, authService);
    }

}