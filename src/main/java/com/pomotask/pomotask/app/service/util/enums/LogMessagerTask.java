package com.pomotask.pomotask.app.service.util.enums;

import com.pomotask.pomotask.app.model.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogMessagerTask {

    UPDATE("Object Class: "
            + TaskModel
            .class
            .getName()
            .substring(0, TaskModel.class.getName().length() - 5)
            + ", Action: UPDATE, ID: ");

    private String text;

}
