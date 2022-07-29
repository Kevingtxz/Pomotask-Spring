package com.pomotask.pomotask.main.dto.view;

import com.pomotask.pomotask.main.domain.TimerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TimerManagerView {


    private Integer id;
    private Long createdAt;
    private Integer timeSeconds;
    private Integer goalNumberTimers;
    private Long finishAt;
    private boolean successful;
    private List<TimerModel> timerEntityList = new ArrayList<>();

}
