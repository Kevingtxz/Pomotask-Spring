package com.pomotask.pomotask.app.service;

import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.model.TimerManagerModel;

import java.util.Set;

public interface TimerManagerService {


    Set<TimerManagerModel> findAllByUserId(Integer userId);
    TimerManagerModel findByUserIdAndId(Integer userId, Integer id);
    TimerManagerModel insert(Integer userId, TimerManagerForm form);
    void deleteByUserIdAndId(Integer userId, Integer id);
    void update(Integer userId, Integer id, TimerManagerForm form);

}
