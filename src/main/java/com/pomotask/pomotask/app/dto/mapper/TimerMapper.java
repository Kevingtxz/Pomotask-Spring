package com.pomotask.pomotask.app.dto.mapper;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.dto.view.TimerView;
import com.pomotask.pomotask.app.model.TimerModel;
import org.springframework.stereotype.Component;

@Component
public class TimerMapper extends AbsMapper<TimerModel, TimerForm, TimerView> {


    @Override
    public TimerView toView(TimerModel model) {
        return mapper.map(model, TimerView.class);
    };

    @Override
    public TimerModel toModel(TimerForm form){
        return mapper.map(form, TimerModel.class);
    }

}
