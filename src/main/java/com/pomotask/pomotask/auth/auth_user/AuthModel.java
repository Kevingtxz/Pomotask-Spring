package com.pomotask.pomotask.auth.auth_user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pomotask.pomotask.auth.auth_user.enums.ProfileRole;
import com.pomotask.pomotask.auth.user.UserModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "AUTH_USERS")
public class AuthModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(nullable = false)
    private boolean active = true;
    @ToString.Include
    @Column(nullable = false)
    private Long createdAt = new Date().getTime();
    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "auth", cascade = CascadeType.ALL)
    private UserModel user = new UserModel();
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PROFILE_ROLES")
    private Set<Integer> profileRoles = new HashSet<Integer>() {{
        add(ProfileRole.USER.getCod());
    }};


    public AuthModel(String email) {
        this.email = email;
    }


    public Set<ProfileRole> getProfileRoles() {
        return this.profileRoles
                .stream()
                .map(e -> ProfileRole.toEnum(e))
                .collect(Collectors.toSet());
    }

    public void addProfileRole(ProfileRole profileRole) {
        this.profileRoles.add(profileRole.getCod());
    }

}
