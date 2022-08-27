package com.pomotask.pomotask.app.service;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.model.TimerModel;

import java.util.Set;

public interface TimerService {


    Set<TimerModel> findAllByUserId(Integer userId);
    TimerModel findByUserIdAndId(Integer userId, Integer id);
    TimerModel insert(Integer userId, TimerManagerModel timerManager, TimerForm form);
    void deleteByUserIdAndId(Integer userId, Integer id);
    void update(Integer userId, Integer id, TimerForm form);

}
