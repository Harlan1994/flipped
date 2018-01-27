package com.harlan.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Harlan1994 on 2017/11/20.
 */
@Table(name = "tb_user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;


    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    @Column(name = "roles", nullable = false)
    private List<Role> roles;


    @OneToOne(fetch = FetchType.EAGER)
    private UserInfo userInfo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null || roles.size() < 1) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        for (Role role : roles) {
            commaBuilder.append(role.getRoleName()).append(",");
        }
        String authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userInfo.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
