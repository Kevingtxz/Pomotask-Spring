package com.pomotask.pomotask.app.dto.view;

import com.pomotask.pomotask.app.model.TaskModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class TimerView {


    private Integer id;
    private Integer timeMinutes;
    private int stopsCounter;
    private boolean successful;
    private Long createdAt;
    private Long finishedAt;
    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private TaskModel task;

}