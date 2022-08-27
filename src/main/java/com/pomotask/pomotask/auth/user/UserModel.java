package com.pomotask.pomotask.auth.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.auth.auth.AuthModel;
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


    @Column(nullable = false)
    private boolean active = true;
    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "AUTH_USER", nullable = false)
    private AuthModel auth;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TimerManagerModel> timerManagerSet = new HashSet<>();

}
