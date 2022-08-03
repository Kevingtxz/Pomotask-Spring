package com.pomotask.pomotask.app.dto.mapper;

import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.dto.form.TaskForm;
import com.pomotask.pomotask.app.dto.view.TaskView;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper extends AbsMapper<TaskModel, TaskForm, TaskView> {


    @Override
    public TaskView toView(TaskModel model) {
        return mapper.map(model, TaskView.class);
    };

    @Override
    public TaskModel toModel(TaskForm form){
        return mapper.map(form, TaskModel.class);
    }

}
