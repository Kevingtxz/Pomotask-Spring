package com.pomotask.pomotask.config.db_simulation;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.model.TimerModel;
import com.pomotask.pomotask.auth.auth_user.AuthModel;
import com.pomotask.pomotask.auth.auth_user.AuthService;
import com.pomotask.pomotask.auth.user.UserModel;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.dto.form.TaskForm;
import com.pomotask.pomotask.app.service.TaskService;
import com.pomotask.pomotask.app.service.TimerManagerService;
import com.pomotask.pomotask.app.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DBService {


    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private TimerManagerService timerManagerService;
    @Autowired
    private TimerService timerService;
    @Autowired
    private TaskService taskService;


    public void instantiateTestDatabase() {

        try {

            AuthModel me = authService.findOrInsertByEmail("kevingtxz@gmail.com");
            AuthModel a1 = authService.findOrInsertByEmail("email1@example.com");
            AuthModel a2 = authService.findOrInsertByEmail("email2@example.com");
            AuthModel a3 = authService.findOrInsertByEmail("email3@example.com");
            AuthModel a4 = authService.findOrInsertByEmail("email4@example.com");
            AuthModel a5 = authService.findOrInsertByEmail("email5@example.com");
            AuthModel a6 = authService.findOrInsertByEmail("email6@example.com");
            AuthModel a7 = authService.findOrInsertByEmail("email7@example.com");
            AuthModel a8 = authService.findOrInsertByEmail("email8@example.com");
            AuthModel a9 = authService.findOrInsertByEmail("email9@example.com");
            AuthModel a0 = authService.findOrInsertByEmail("email0@example.com");

            TaskForm tf = new TaskForm();
            tf.setCreatedAt(new Date().getTime());
            tf.setTitle("First");
            tf.setCrucial(true);
            tf.setDeadline(new Date().getTime() + 86400000 * 10);
            tf.setHard(true);
            tf.setExpectedTimeHours(100);
            tf.setHealthLevel(10);
            tf.setSuccessful(false);
            tf.setWorkedTimeMinutes(5);
            TaskModel t1 = taskService.insert(me.getId(), tf);
            tf.setTitle("Second");
            TaskModel t2 = taskService.insert(a1.getId(), tf);
            tf.setTitle("Third");
            TaskModel t3 = taskService.insert(a1.getId(), tf);
//            TaskModel t4 = taskService.insert(a1.getId(), tf);
//            TaskModel t5 = taskService.insert(a1.getId(), tf);
//            TaskModel t6 = taskService.insert(a2.getId(), tf);
//            TaskModel t7 = taskService.insert(a3.getId(), tf);
//            TaskModel t8 = taskService.insert(a4.getId(), tf);
//            TaskModel t9 = taskService.insert(a5.getId(), tf);
//            TaskModel t0 = taskService.insert(a6.getId(), tf);


//            TimerForm tif1 = new TimerForm();
//            tif1.setCreatedAt(new Date().getTime());
//            tif1.setStopsCounter(10);
//            tif1.setTaskId(t1.getId());
//            tif1.setTimeMinutes(60);
//
//            TimerModel ti1 = timerService.insert(me.getId(), tif1);
//            TimerModel ti2 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti3 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti4 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti5 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti6 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti7 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti8 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti9 = timerService.insert(a1.getId(), tif1);
//            TimerModel ti0 = timerService.insert(a1.getId(), tif1);

            UserModel u1 = userService.findById(a1.getId());
            u1.getTaskSet().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
