package com.pomotask.pomotask.main.resource;

import com.pomotask.pomotask.main.domain.TimerManagerModel;
import com.pomotask.pomotask.main.dto.form.TimerManagerForm;
import com.pomotask.pomotask.main.dto.mapper.TimerManagerMapper;
import com.pomotask.pomotask.main.dto.view.TimerManagerView;
import com.pomotask.pomotask.main.service.TimerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "big-timers")
public class TimerManagerResource extends AbsResource<TimerManagerModel, TimerManagerForm, TimerManagerView> {


    @Autowired
    public TimerManagerResource(TimerManagerService service, TimerManagerMapper mapper) {
        super(service, mapper);
    }

}
