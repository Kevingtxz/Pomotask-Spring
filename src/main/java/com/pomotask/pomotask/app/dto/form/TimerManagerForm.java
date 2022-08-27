package com.pomotask.pomotask.app.dto.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TimerManagerForm {


    @NotNull
    private String createdAt;
    @NotNull
    private Integer timeSeconds;
    @NotNull
    private Integer goalNumberTimers;
    @NotNull
    private String finishAt;
    @NotNull
    private boolean successful;
    private Set<TimerForm> timerEntitySet = new HashSet<>();

}