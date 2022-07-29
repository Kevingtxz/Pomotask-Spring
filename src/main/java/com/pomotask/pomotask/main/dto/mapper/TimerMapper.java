package com.pomotask.pomotask.main.dto.mapper;

import com.pomotask.pomotask.main.domain.TimerModel;
import com.pomotask.pomotask.main.dto.form.TimerForm;
import com.pomotask.pomotask.main.dto.view.TimerView;
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
