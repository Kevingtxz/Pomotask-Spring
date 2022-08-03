package com.pomotask.pomotask.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pomotask.pomotask.auth.user.UserModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@MappedSuperclass
public abstract class AbsModel extends RepresentationModel<AbsModel>
        implements Serializable {


    @Column(nullable = false)
    private boolean active = true;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(nullable = false, updatable=false)
    private final Long createdAt = new Date().getTime();
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserModel user;

}
