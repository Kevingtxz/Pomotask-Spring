package com.pomotask.pomotask.app.dto.form;

import com.pomotask.pomotask.app.model.TaskModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TaskForm extends AbsForm<TaskModel> {


    @NotBlank
    private String title;
    @NotNull
    private Integer expectedTimeHours;
    @NotNull
    private Integer workedTimeMinutes;
    @NotNull
    private boolean successful;
    @NotNull
    private boolean hard;
    @NotNull
    private boolean crucial;
    @NotNull
    private String deadline;
    @NotNull
    private String createdAt;
    private String finishedAt;

}