package com.pomotask.pomotask.main.repository;

import com.pomotask.pomotask.main.domain.TaskModel;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends AbsRepository<TaskModel> {}
