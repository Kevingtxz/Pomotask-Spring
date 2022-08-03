package com.pomotask.pomotask.app.dto.mapper;

import com.pomotask.pomotask.app.model.AbsModel;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public abstract class AbsMapper<Model extends AbsModel, Form, View> {


    protected ModelMapper mapper;


    public AbsMapper() {
        mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Model, View>() {
            @Override
            protected void configure(){}
        });
        mapper.addMappings(new PropertyMap<Form, Model>() {
            @Override
            protected void configure(){}
        });
    }


    public abstract View toView(Model model);

    public abstract Model toModel(Form form);

    public List<Model> toModelList(List<Form> listForm) {
        return listForm.stream()
                .map(form -> toModel(form))
                .collect(Collectors.toList());
    }

    public List<View> toViewList(List<Model> listEntity) {
        return listEntity.stream()
                .map(obj -> toView(obj))
                .collect(Collectors.toList());
    }

}
