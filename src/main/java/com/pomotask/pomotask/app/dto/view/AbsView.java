package com.pomotask.pomotask.app.dto.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pomotask.pomotask.app.model.AbsModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public abstract class AbsView<Model extends AbsModel>
        extends RepresentationModel<AbsView<Model>> {


    private String createdAt;
    private Integer id;

}
