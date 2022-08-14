package com.pomotask.pomotask.app.dto.form;

import com.pomotask.pomotask.app.model.TimerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TimerForm extends AbsForm<TimerModel> {


    @NotNull
    private Integer timeMinutes;
    @NotNull
    private int stopsCounter;
    @NotNull
    private boolean successful;
    @NotNull
    private String finishedAt;
    @NotNull
    private String createdAt;
    @NotNull
    private Integer taskId;

}
