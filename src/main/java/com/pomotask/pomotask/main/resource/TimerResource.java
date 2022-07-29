package com.pomotask.pomotask.main.resource;

import com.pomotask.pomotask.main.domain.TimerModel;
import com.pomotask.pomotask.main.dto.form.TimerForm;
import com.pomotask.pomotask.main.dto.mapper.TimerMapper;
import com.pomotask.pomotask.main.dto.view.TimerView;
import com.pomotask.pomotask.main.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "timers")
public class TimerResource extends AbsResource<TimerModel, TimerForm, TimerView> {


    @Autowired
    public TimerResource(TimerService service, TimerMapper mapper) {
        super(service, mapper);
    }

}
