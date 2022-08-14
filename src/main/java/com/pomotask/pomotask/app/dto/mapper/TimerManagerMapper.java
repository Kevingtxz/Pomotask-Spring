package com.pomotask.pomotask.app.dto.mapper;

import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.dto.view.TimerManagerView;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import org.springframework.stereotype.Component;

@Component
public class TimerManagerMapper extends AbsMapper<TimerManagerModel, TimerManagerForm, TimerManagerView> {


    @Override
    public TimerManagerView toView(TimerManagerModel model) {
        return mapper.map(model, TimerManagerView.class);
    };

    @Override
    public TimerManagerModel toModel(TimerManagerForm form){
        return mapper.map(form, TimerManagerModel.class);
    }

}
