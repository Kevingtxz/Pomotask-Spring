package com.pomotask.pomotask.config.db_simulation;

import com.pomotask.pomotask.auth.auth.AuthModel;
import com.pomotask.pomotask.auth.auth.AuthService;
import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.service.impl.TimerManagerServiceImpl;
import com.pomotask.pomotask.app.service.impl.TimerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.pomotask.pomotask.util.DateFormatterUtil.DATE_FORMAT;

@Service
public class DBService {


    @Autowired
    private AuthService authService;
    @Autowired
    private TimerManagerServiceImpl timerManagerService;
    @Autowired
    private TimerServiceImpl timerService;


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


            TimerManagerForm tmf1 = new TimerManagerForm();
            tmf1.setCreatedAt(DATE_FORMAT.format(new Date()));
            tmf1.setTimeSeconds(3600);
            tmf1.setSuccessful(false);
            tmf1.setFinishAt(DATE_FORMAT.format(new Date().getTime() + 60 * 60 * 24 * 2));
            tmf1.setGoalNumberTimers(3);

            TimerManagerForm tmf2 = new TimerManagerForm();
            tmf2.setCreatedAt(DATE_FORMAT.format(new Date()));
            tmf2.setTimeSeconds(3600);
            tmf2.setSuccessful(false);
            tmf2.setFinishAt(DATE_FORMAT.format(new Date().getTime() + 60 * 60 * 24 * 2));
            tmf2.setGoalNumberTimers(3);

            TimerForm tif1 = new TimerForm();
            tif1.setStopsCounter(10);
            tif1.setTimeSeconds(60);
            tif1.setSuccessful(false);
            tif1.setCreatedAt(DATE_FORMAT.format(new Date()));
            tif1.setFinishedAt(DATE_FORMAT.format(new Date().getTime() + 60 * 60 * 24 * 2));
            TimerForm tif2 = new TimerForm();
            tif2.setStopsCounter(10);
            tif2.setTimeSeconds(60);
            tif2.setSuccessful(false);
            tif2.setCreatedAt(DATE_FORMAT.format(new Date()));
            tif2.setFinishedAt(DATE_FORMAT.format(new Date().getTime() + 60 * 60 * 24 * 2));

            tmf1.getTimerEntitySet().add(tif1);
            tmf1.getTimerEntitySet().add(tif2);

            TimerForm tif3 = new TimerForm();
            tif3.setStopsCounter(10);
            tif3.setTimeSeconds(60);
            tif3.setSuccessful(false);
            tif3.setCreatedAt(DATE_FORMAT.format(new Date()));
            tif3.setFinishedAt(DATE_FORMAT.format(new Date().getTime() + 60 * 60 * 24 * 2));

            tmf2.getTimerEntitySet().add(tif3);

            TimerManagerModel tmm1 = timerManagerService.insert(me.getUser().getId(), tmf1);
            TimerManagerModel tmm2 = timerManagerService.insert(me.getUser().getId(), tmf2);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
