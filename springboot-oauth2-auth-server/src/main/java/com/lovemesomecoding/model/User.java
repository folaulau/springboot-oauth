package com.lovemesomecoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer           id;

    @Column(name = "username", unique = true, updatable = true, nullable = false)
    private String            username;

    @Column(name = "password")
    private String            password;

    @Column(name = "email", unique = true, updatable = true, nullable = false)
    private String            email;

    @Type(type = "true_false")
    @Column(name = "enabled")
    private boolean           enabled;

    @Type(type = "true_false")
    @Column(name = "accountNonExpired")
    private boolean           accountNonExpired;

    @Type(type = "true_false")
    @Column(name = "credentialsNonExpired")
    private boolean           credentialsNonExpired;

    @Type(type = "true_false")
    @Column(name = "accountNonLocked")
    private boolean           accountNonLocked;

    @JsonIgnoreProperties("user")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    private List<UserRole>    roles;

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    public void addRole(UserRole role) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
    }

}
