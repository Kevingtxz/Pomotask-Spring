package com.pomotask.pomotask.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TIMERS")
public class TimerModel extends AbsModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(nullable = false)
    private Integer timeMinutes;
    @Column(nullable = false)
    private int stopsCounter;
    @Column(nullable = false)
    private boolean successful;
    @Column(nullable = false)
    private String finishedAt;
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "TASK_ID")
    private TaskModel task;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "TIMER_MANAGER_ID", nullable = false)
    private TimerManagerModel timerManager;

}
