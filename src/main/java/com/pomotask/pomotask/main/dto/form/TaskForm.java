package com.pomotask.pomotask.main.dto.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TaskForm  {


    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private Integer expectedTimeHours;
    @NotNull
    private Integer workedTimeMinutes;
    @NotNull
    private Integer healthLevel;
    @NotNull
    private boolean successful;
    @NotNull
    private boolean hard;
    @NotNull
    private boolean crucial;
    @NotNull
    private Long deadline;
    @NotNull
    private Long createdAt;
    private Long finishedAt;

}