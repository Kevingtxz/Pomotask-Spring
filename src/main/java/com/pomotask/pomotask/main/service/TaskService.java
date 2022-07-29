package com.pomotask.pomotask.main.service;

import com.pomotask.pomotask.auth.auth_user.AuthService;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.main.domain.TaskModel;
import com.pomotask.pomotask.main.dto.form.TaskForm;
import com.pomotask.pomotask.main.dto.mapper.TaskMapper;
import com.pomotask.pomotask.main.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskService extends AbsService<TaskModel, TaskForm> {


    @Autowired
    public TaskService(TaskRepository repo, TaskMapper mapper, UserService userService) {
        super(repo, mapper, userService);
    }

    @Override
    protected Set<TaskModel> modelSet(String userEmail) {
        return userService.findTaskFinishedSetByUserEmail(userEmail);
    }

}
