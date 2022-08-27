package com.pomotask.pomotask.app.dto.view;

import com.pomotask.pomotask.app.model.TimerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimerView extends AbsView<TimerModel> {


    private Integer timeMinutes;
    private int stopsCounter;
    private boolean successful;
    private String finishedAt;
    private String taskDescription;
    private Integer timerManagerId;

}
