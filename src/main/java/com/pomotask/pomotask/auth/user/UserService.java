package com.pomotask.pomotask.auth.user;


import com.pomotask.pomotask.main.domain.TaskModel;
import com.pomotask.pomotask.main.domain.TimerManagerModel;
import com.pomotask.pomotask.main.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserService {


    @Autowired
    private UserRepository repo;


    public UserModel findById(Integer id) {
        return this.repo.findById(id)
                .orElseThrow(()  ->
                        new ObjectNotFoundException(
                                "User not found."));
    }

    public UserModel findByEmail(String email) {
        return this.repo.findByAuthEmail(email)
                .orElseThrow(()  ->
                        new ObjectNotFoundException(
                                "User not found."));
    }

    public Set<TimerManagerModel> findTimerManagerSetByUserEmail(String email) {
        return this.repo.findTimerManagerSetInUserByUserEmail(email);
    }

    public Set<TaskModel> findTaskSetByUserEmail(String email) {
        return this.repo.findTaskSetInUserByUserEmail(email);
    }

    public Set<TaskModel> findTaskFinishedSetByUserEmail(String email) {
        return this.repo.findTaskFinishedSetInUserByUserEmail(email);
    }

    public UserModel insert(UserModel user) {
        return this.repo.save(user);
    }

}