package com.pomotask.pomotask.app.dto.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TimerForm {


    @NotNull
    private Integer timeSeconds;
    @NotNull
    private int stopsCounter;
    @NotNull
    private boolean successful;
    @NotNull
    private String finishedAt;
    @NotNull
    private String createdAt;
    private String taskDescription;

}
