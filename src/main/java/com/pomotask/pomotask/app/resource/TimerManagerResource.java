package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerManagerMapper;
import com.pomotask.pomotask.app.dto.view.TimerManagerView;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.service.TimerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pomotask.pomotask.util.VersionUtil.API_VERSION_FOR_URL;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "/timer-managers")
public class TimerManagerResource extends AbsResource<TimerManagerModel, TimerManagerForm, TimerManagerView> {


    @Autowired
    public TimerManagerResource(TimerManagerService service, TimerManagerMapper mapper) {
        super(service, mapper);
    }

}
