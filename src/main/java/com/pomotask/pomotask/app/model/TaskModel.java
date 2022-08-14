package com.pomotask.pomotask.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TASKS")
public class TaskModel extends AbsModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(unique = true, length = 200)
    private String title;
    @Column(nullable = false)
    private boolean hard;
    @Column(nullable = false)
    private boolean successful;
    @Column(nullable = false)
    private Integer expectedTimeHours;
    @Column(nullable = false)
    private Integer workedTimeMinutes;
    @Column(nullable = false)
    private String deadline;
    private String finishedAt;

}