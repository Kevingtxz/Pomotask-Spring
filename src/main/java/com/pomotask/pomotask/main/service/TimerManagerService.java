package com.pomotask.pomotask.main.service;

import com.pomotask.pomotask.auth.auth_user.AuthService;
import com.pomotask.pomotask.main.domain.TimerManagerModel;
import com.pomotask.pomotask.main.dto.form.TimerManagerForm;
import com.pomotask.pomotask.main.dto.mapper.TimerManagerMapper;
import com.pomotask.pomotask.main.repository.TimerManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimerManagerService extends AbsService<TimerManagerModel, TimerManagerForm> {


    @Autowired
    public TimerManagerService(TimerManagerRepository repo, TimerManagerMapper mapper, AuthService authService) {
        super(repo, mapper, authService);
    }

}
