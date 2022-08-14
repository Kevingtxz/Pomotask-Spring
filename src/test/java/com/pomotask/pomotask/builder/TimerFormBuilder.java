package com.pomotask.pomotask.builder;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import lombok.Builder;

import java.util.Date;

import static com.pomotask.pomotask.util.DateFormatterUtil.DATE_FORMAT;

@Builder
public class TimerFormBuilder {


    @Builder.Default
    private Integer timeMinutes = 60;
    @Builder.Default
    private int stopsCounter = 2;
    @Builder.Default
    private boolean successful = false;
    @Builder.Default
    private String createdAt = DATE_FORMAT.format(new Date());
    @Builder.Default
    private String finishedAt = DATE_FORMAT.format(new Date());
    @Builder.Default
    private Integer taskId = 2000;
    @Builder.Default
    private Integer userId = 1000;


    public TimerForm toForm() {
        TimerForm form = new TimerForm();
        form.setTimeMinutes(timeMinutes);
        form.setStopsCounter(stopsCounter);
        form.setSuccessful(successful);
        form.setCreatedAt(createdAt);
        form.setFinishedAt(finishedAt);
        form.setTaskId(taskId);
        return form;
    }

}