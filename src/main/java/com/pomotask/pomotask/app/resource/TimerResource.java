package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerMapper;
import com.pomotask.pomotask.app.dto.view.TimerView;
import com.pomotask.pomotask.app.model.TimerModel;
import com.pomotask.pomotask.app.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pomotask.pomotask.util.VersionUtil.API_VERSION_FOR_URL;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "/timers")
public class TimerResource extends AbsResource<TimerModel, TimerForm, TimerView> {


    @Autowired
    public TimerResource(TimerService service, TimerMapper mapper) {
        super(service, mapper);
    }

}
