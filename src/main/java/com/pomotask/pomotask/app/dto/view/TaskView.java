package com.pomotask.pomotask.app.dto.view;

import com.pomotask.pomotask.app.model.TaskModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskView extends AbsView<TaskModel> {


    private String title;
    private Integer expectedTimeHours;
    private Integer workedTimeMinutes;
    private boolean successful;
    private boolean hard;
    private boolean crucial;
    private String deadline;
    private String finishedAt;

}