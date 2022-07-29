package com.pomotask.pomotask.auth.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pomotask.pomotask.auth.auth_user.AuthModel;
import com.pomotask.pomotask.main.domain.TimerManagerModel;
import com.pomotask.pomotask.main.domain.TaskModel;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "AUTH_ID")
    private AuthModel auth;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TimerManagerModel> timerManagerSet = new HashSet<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaskModel> taskSet = new HashSet<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaskModel> taskFinishedSet = new HashSet<>();

}
