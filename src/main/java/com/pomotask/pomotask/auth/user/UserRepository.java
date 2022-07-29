package com.pomotask.pomotask.auth.user;

import com.pomotask.pomotask.main.domain.TimerManagerModel;
import com.pomotask.pomotask.main.domain.TaskModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {


    @Transactional(readOnly = true)
    @Query("SELECT u.timerManagerSet FROM UserModel AS u WHERE u.auth.email=:userEmail")
    Set<TimerManagerModel> findTimerManagerSetInUserByUserEmail(String userEmail);
    @Transactional(readOnly = true)
    @Query("SELECT u.timerManagerSet FROM UserModel AS u WHERE u.auth.email=:userEmail")
    Page<TimerManagerModel> findTimerManagerPageInUserByUserEmail(String userEmail, PageRequest pageRequest);
    @Transactional(readOnly = true)
    @Query("SELECT u.taskSet FROM UserModel AS u WHERE u.auth.email=:userEmail")
    Set<TaskModel> findTaskSetInUserByUserEmail(String userEmail);
    @Transactional(readOnly = true)
    @Query("SELECT u.taskSet FROM UserModel AS u WHERE u.auth.email=:userEmail")
    Page<TaskModel> findTaskPageInUserByUserEmail(String userEmail, PageRequest pageRequest);
    @Transactional(readOnly = true)
    @Query("SELECT u.taskFinishedSet FROM UserModel AS u WHERE u.auth.email=:userEmail")
    Set<TaskModel> findTaskFinishedSetInUserByUserEmail(String userEmail);
    @Transactional(readOnly = true)
    @Query("SELECT u.taskFinishedSet FROM UserModel AS u WHERE u.auth.email=:userEmail")
    Page<TaskModel> findTaskFinishedPageInUserByUserEmail(String userEmail, PageRequest pageRequest);
    @Transactional(readOnly = true)
    Optional<UserModel> findByAuthEmail(String email);

}
