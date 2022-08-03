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
    private Long createdAt;
    @NotNull
    private Integer timeSeconds;
    @NotNull
    private Integer goalNumberTimers;
    @NotNull
    private Long finishAt;
    @NotNull
    private boolean successful;
    private Set<TimerForm> timerEntitySet = new HashSet<>();

}