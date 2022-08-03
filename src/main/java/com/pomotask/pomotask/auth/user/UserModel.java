package com.pomotask.pomotask.auth.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pomotask.pomotask.auth.auth_user.AuthModel;
import com.pomotask.pomotask.app.model.TaskModel;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ID")
    @MapsId
    private AuthModel auth;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TimerManagerModel> timerManagerSet = new HashSet<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TaskModel> taskSet = new HashSet<>();

}
