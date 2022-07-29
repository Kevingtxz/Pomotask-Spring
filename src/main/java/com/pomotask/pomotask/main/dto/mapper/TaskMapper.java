package com.pomotask.pomotask.main.dto.mapper;

import com.pomotask.pomotask.main.domain.TaskModel;
import com.pomotask.pomotask.main.dto.form.TaskForm;
import com.pomotask.pomotask.main.dto.view.TaskView;
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
