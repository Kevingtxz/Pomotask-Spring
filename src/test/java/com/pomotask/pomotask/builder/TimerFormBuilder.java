package com.pomotask.pomotask.builder;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import lombok.Builder;

import java.util.Date;

import static com.pomotask.pomotask.util.DateFormatterUtil.DATE_FORMAT;

@Builder
public class TimerFormBuilder {


    @Builder.Default
    private Integer timeSeconds = 60;
    @Builder.Default
    private int stopsCounter = 2;
    @Builder.Default
    private boolean successful = false;
    @Builder.Default
    private String createdAt = DATE_FORMAT.format(new Date());
    @Builder.Default
    private String finishedAt = DATE_FORMAT.format(new Date().getTime() + 60 * 60 * 24 * 2);
    @Builder.Default
    private Integer userId = 1000;
    @Builder.Default
    private String taskDescription = "Making Pomotask";


    public TimerForm toForm() {
        TimerForm form = new TimerForm();
        form.setTimeSeconds(timeSeconds);
        form.setStopsCounter(stopsCounter);
        form.setSuccessful(successful);
        form.setCreatedAt(createdAt);
        form.setFinishedAt(finishedAt);
        return form;
    }

}