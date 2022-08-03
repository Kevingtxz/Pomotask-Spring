package com.pomotask.pomotask.auth.user;

import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {


    @Transactional(readOnly = true)
    @Query("SELECT u.timerManagerSet FROM UserModel AS u WHERE u.id=:id")
    Set<TimerManagerModel> findTimerManagerSetById(Integer id);
    @Transactional(readOnly = true)
    @Query("SELECT u.taskSet FROM UserModel AS u WHERE u.id=:id")
    Set<TaskModel> findTaskSetById(Integer id);

}
