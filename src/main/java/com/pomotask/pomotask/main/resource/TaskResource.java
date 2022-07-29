package com.pomotask.pomotask.main.resource;

import com.pomotask.pomotask.main.domain.TaskModel;
import com.pomotask.pomotask.main.dto.form.TaskForm;
import com.pomotask.pomotask.main.dto.mapper.TaskMapper;
import com.pomotask.pomotask.main.dto.view.TaskView;
import com.pomotask.pomotask.main.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "tasks")
public class TaskResource extends AbsResource<TaskModel, TaskForm, TaskView> {


    @Autowired
    public TaskResource(TaskService service, TaskMapper mapper) {
        super(service, mapper);
    }

}
