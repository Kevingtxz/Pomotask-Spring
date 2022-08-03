package com.pomotask.pomotask.app.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskView {


    private Integer id;
    private String title;
    private Integer expectedTimeHours;
    private Integer workedTimeMinutes;
    private Integer priorityLevel;
    private Integer healthLevel;
    private boolean successful;
    private boolean hard;
    private boolean crucial;
    private Long deadline;
    private Long createdAt;
    private Long finishedAt;

}