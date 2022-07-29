package com.pomotask.pomotask.main.dto.mapper;

import com.pomotask.pomotask.main.domain.TimerManagerModel;
import com.pomotask.pomotask.main.dto.form.TimerManagerForm;
import com.pomotask.pomotask.main.dto.view.TimerManagerView;
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
