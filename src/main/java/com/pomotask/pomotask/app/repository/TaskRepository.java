package com.pomotask.pomotask.app.repository;

import com.pomotask.pomotask.app.model.TaskModel;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends AbsRepository<TaskModel> {}
