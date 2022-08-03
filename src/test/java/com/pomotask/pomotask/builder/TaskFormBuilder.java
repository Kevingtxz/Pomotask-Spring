package com.pomotask.pomotask.builder;

import com.pomotask.pomotask.app.dto.form.TaskForm;
import lombok.Builder;

import java.util.Date;

@Builder
public class TaskFormBuilder {


    @Builder.Default
    private String title = "Pomotask";
    @Builder.Default
    private Integer expectedTimeHours = 300;
    @Builder.Default
    private Integer workedTimeMinutes = 6000;
    @Builder.Default
    private Integer healthLevel = 10;
    @Builder.Default
    private boolean successful = false;
    @Builder.Default
    private boolean hard = false;
    @Builder.Default
    private boolean crucial = true;
    @Builder.Default
    private Long deadline = new Date().getTime();
    @Builder.Default
    private Long createdAt = new Date().getTime();
    @Builder.Default
    private Long finishedAt = new Date().getTime();


    public TaskForm toForm() {
        TaskForm form = new TaskForm();
        form.setTitle(title);
        form.setExpectedTimeHours(expectedTimeHours);
        form.setWorkedTimeMinutes(workedTimeMinutes);
        form.setHealthLevel(healthLevel);
        form.setSuccessful(successful);
        form.setHard(hard);
        form.setCrucial(crucial);
        form.setDeadline(deadline);
        form.setCreatedAt(createdAt);
        form.setFinishedAt(finishedAt);
        return form;
    }

}