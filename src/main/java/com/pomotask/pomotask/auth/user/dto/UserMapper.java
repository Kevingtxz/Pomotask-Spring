package com.pomotask.pomotask.auth.user.dto;

import com.pomotask.pomotask.auth.user.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    private ModelMapper mapper;


    public UserMapper() {
        this.mapper = new ModelMapper();
        this.mapper.addMappings(new PropertyMap<UserModel, UserView>() {
            @Override
            protected void configure(){}
        });
        this.mapper.addMappings(new PropertyMap<UserForm, UserModel>() {
            @Override
            protected void configure(){}
        });
    }


    public UserView toView(UserModel model) {
        return this.mapper.map(model, UserView.class);
    }

    public UserModel toModel(UserForm form) {
        return this.mapper.map(form, UserModel.class);
    }

    public List<UserModel> toUserEntityList(List<UserForm> listUserForm) {
        return listUserForm.stream()
                .map(form -> toModel(form))
                .collect(Collectors.toList());
    }

    public List<UserView> toUserViewList(List<UserModel> listUserEntity) {
        return listUserEntity.stream()
                .map(obj -> toView(obj))
                .collect(Collectors.toList());
    }

}
