package com.pomotask.pomotask.app.dto.view;

import com.pomotask.pomotask.app.model.TimerManagerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TimerManagerView extends AbsView<TimerManagerModel> {


    private Integer timeSeconds;
    private Integer goalNumberTimers;
    private String finishAt;
    private boolean successful;
    private List<TimerView> timerList = new ArrayList<>();

}
