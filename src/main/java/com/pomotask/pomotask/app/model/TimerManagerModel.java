package com.pomotask.pomotask.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TIMER_MANAGER")
public class TimerManagerModel extends AbsModel implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer timeSeconds;
    @Column(unique = true, length = 200)
    private Integer goalNumberTimers;
    private String finishAt;
    @Column(nullable = false)
    private boolean successful;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "timerManager", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TimerModel> timerSet = new HashSet<>();

}
