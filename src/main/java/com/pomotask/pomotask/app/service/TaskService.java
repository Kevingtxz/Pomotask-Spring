package com.pomotask.pomotask.app.service;

import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.dto.form.TaskForm;
import com.pomotask.pomotask.app.dto.mapper.TaskMapper;
import com.pomotask.pomotask.app.dto.view.TaskView;
import com.pomotask.pomotask.app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskService extends AbsService<TaskModel, TaskForm, TaskView> {


    @Autowired
    public TaskService(TaskRepository repo, TaskMapper mapper, UserService userService) {
        super(repo, mapper, userService);
    }

    @Override
    protected Set<TaskModel> modelSet(Integer userId) {
        return userService.findTaskSetById(userId);
    }

    protected String currentClassModelStr() {
        return TaskModel.class.getName();
    }

}
