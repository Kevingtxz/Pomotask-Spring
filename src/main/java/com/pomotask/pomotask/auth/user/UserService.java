package com.pomotask.pomotask.auth.user;


import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.model.TimerModel;
import com.pomotask.pomotask.app.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService {


    @Autowired
    private UserRepository repo;



    public UserModel findById(Integer id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "User not found. ID:" + id + "."));
    }

    public UserModel insert(UserModel user) {
        return this.repo.save(user);
    }

    public Set<TimerModel> findTimerSetById(Integer id) {
        Set<TimerModel> modelSet = new HashSet<>();
        this.findTimerManagerSetById(id)
                .stream()
                .forEach(obj -> obj.getTimerEntitySet()
                        .forEach(modelSet::add));
        return modelSet;
    }

    public Set<TimerManagerModel> findTimerManagerSetById(Integer id) {
        return this.repo.findTimerManagerSetById(id);
    }

    public Set<TaskModel> findTaskSetById(Integer id) {
        return this.repo.findTaskSetById(id);
    }

}