package com.pomotask.pomotask.main.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TASKS")
public class TaskModel extends AbsModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(unique = true, length = 200)
    private String title;
    @Column(nullable = false)
    private boolean hard;
    @Column(nullable = false)
    private boolean crucial;
    @Column(nullable = false)
    private boolean successful;
    @Column(nullable = false)
    private Integer expectedTimeHours;
    @Column(nullable = false)
    private Integer workedTimeMinutes;
    @Column(nullable = false)
    private Integer healthLevel;
    @Column(nullable = false)
    private Long deadline;
    private Long finishedAt;

}