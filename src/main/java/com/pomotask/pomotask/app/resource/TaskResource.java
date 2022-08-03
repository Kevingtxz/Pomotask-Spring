package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.dto.form.TaskForm;
import com.pomotask.pomotask.app.dto.mapper.TaskMapper;
import com.pomotask.pomotask.app.dto.view.TaskView;
import com.pomotask.pomotask.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pomotask.pomotask.util.Version.API_VERSION_FOR_URL;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "tasks")
public class TaskResource extends AbsResource<TaskModel, TaskForm, TaskView> {


    @Autowired
    public TaskResource(TaskService service, TaskMapper mapper) {
        super(service, mapper);
    }

}
