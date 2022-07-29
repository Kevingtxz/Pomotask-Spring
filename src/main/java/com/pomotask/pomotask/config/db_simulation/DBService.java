package com.pomotask.pomotask.config.db_simulation;

import com.pomotask.pomotask.auth.auth_user.AuthModel;
import com.pomotask.pomotask.auth.auth_user.AuthService;
import com.pomotask.pomotask.main.domain.TaskModel;
import com.pomotask.pomotask.main.dto.form.TaskForm;
import com.pomotask.pomotask.main.service.TimerManagerService;
import com.pomotask.pomotask.main.service.TaskService;
import com.pomotask.pomotask.main.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DBService {


    @Autowired
    private AuthService userService;
    @Autowired
    private TimerManagerService bigTimerService;
    @Autowired
    private TimerService timerService;
    @Autowired
    private TaskService taskService;


    public void instantiateTestDatabase() {

        try {

            AuthModel u1 = userService.findOrInsertByEmail("kevingtxz@gmail.com");
//            UserModel u2 = userService.findOrInsertByEmail("email2@example.com");
//            UserModel u3 = userService.findOrInsertByEmail("email3@example.com");
//            UserModel u4 = userService.findOrInsertByEmail("email4@example.com");
//            UserModel u5 = userService.findOrInsertByEmail("email5@example.com");
//            UserModel u6 = userService.findOrInsertByEmail("email6@example.com");
//            UserModel u7 = userService.findOrInsertByEmail("email7@example.com");
//            UserModel u8 = userService.findOrInsertByEmail("email8@example.com");
//            UserModel u9 = userService.findOrInsertByEmail("email9@example.com");
//            UserModel u0 = userService.findOrInsertByEmail("email0@example.com");

            TaskForm tf1 = new TaskForm();
            tf1.setCreatedAt(new Date().getTime());
            tf1.setTitle("First");
            tf1.setCrucial(true);
            tf1.setDeadline(new Date().getTime() + 86400000 * 10);
            tf1.setHard(true);
            tf1.setExpectedTimeHours(100);
            tf1.setHealthLevel(10);
            tf1.setSuccessful(false);
            tf1.setWorkedTimeMinutes(5);
            TaskModel t1 = taskService.insert(u1.getEmail(), tf1);
//            TaskModel t2 = taskService.insert(u1.getEmail(), new TaskForm());
//            TaskModel t3 = taskService.insert(u1.getEmail(), new TaskForm());
//            TaskModel t4 = taskService.insert(u1.getEmail(), new TaskForm());
//            TaskModel t5 = taskService.insert(u1.getEmail(), new TaskForm());
//            TaskModel t6 = taskService.insert(u2.getEmail(), new TaskForm());
//            TaskModel t7 = taskService.insert(u3.getEmail(), new TaskForm());
//            TaskModel t8 = taskService.insert(u4.getEmail(), new TaskForm());
//            TaskModel t9 = taskService.insert(u5.getEmail(), new TaskForm());
//            TaskModel t0 = taskService.insert(u6.getEmail(), new TaskForm());


//            u1.getTaskEntitySet().addAll(Arrays.asList(t1, t4, t7, t9));
//            t1.setUser(u0);
//            t4.setUser(u0);
//            t7.setUser(u0);
//            t9.setUser(u0);
//
//            TaskForm t1f = new TaskForm();
//            t1f.setTitle("Hahaha");
//
//            taskService.update("kevingtxz@gmail.com", t1f, 1);
//
//
//            BigTimerModel b1 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b2 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b3 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b4 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b5 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b6 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b7 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b8 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b9 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//            BigTimerModel b0 = bigTimerService.insert(u1.getEmail(), new BigTimerForm());
//
//            TimerModel ti1 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti2 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti3 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti4 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti5 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti6 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti7 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti8 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti9 = timerService.insert(u1.getEmail(), new TimerForm());
//            TimerModel ti0 = timerService.insert(u1.getEmail(), new TimerForm());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
