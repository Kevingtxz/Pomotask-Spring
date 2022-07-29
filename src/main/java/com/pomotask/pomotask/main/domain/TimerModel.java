package com.pomotask.pomotask.main.domain;

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
    private Long finishedAt;
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "TASK_ID")
    private TaskModel task;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "BIG_TIMER_ID")
    private TimerManagerModel bigTimer;

}
