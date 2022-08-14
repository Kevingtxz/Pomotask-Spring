package com.pomotask.pomotask.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pomotask.pomotask.auth.user.UserModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.pomotask.pomotask.util.DateFormatterUtil.DATE_FORMAT;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@MappedSuperclass
public abstract class AbsModel implements Serializable {


    @Column(nullable = false)
    private boolean active = true;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(nullable = false, updatable=false)
    private String createdAt = DATE_FORMAT.format(new Date());
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserModel user;

}
