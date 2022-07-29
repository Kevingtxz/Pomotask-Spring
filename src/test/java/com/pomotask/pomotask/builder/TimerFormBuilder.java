package com.pomotask.pomotask.builder;

import com.pomotask.pomotask.main.dto.form.TimerForm;
import lombok.Builder;

import java.util.Date;

@Builder
public class TimerFormBuilder {


    @Builder.Default
    private Integer id = 1;
    @Builder.Default
    private Integer timeMinutes = 60;
    @Builder.Default
    private int stopsCounter = 2;
    @Builder.Default
    private boolean successful = false;
    @Builder.Default
    private Long createdAt = new Date().getTime();
    @Builder.Default
    private Long finishedAt = new Date().getTime();
    @Builder.Default
    private Integer taskId = 2000;
    @Builder.Default
    private Integer userId = 1000;


    public TimerForm toForm() {
        TimerForm form = new TimerForm();
        form.setId(id);
        form.setTimeMinutes(timeMinutes);
        form.setStopsCounter(stopsCounter);
        form.setSuccessful(successful);
        form.setCreatedAt(createdAt);
        form.setFinishedAt(finishedAt);
        form.setTaskId(taskId);
        return form;
    }

}