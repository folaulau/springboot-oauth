package com.lovemesomecoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Integer    id;

    @Column(name = "username")
    private String     username;
    
    @Column(name = "password")
    private String     password;
    
    @Column(name = "email")
    private String     email;
    
    @Column(name = "enabled")
    private boolean    enabled;
    
    @Column(name = "accountNonExpired")
    private boolean    accountNonExpired;
    
    @Column(name = "credentialsNonExpired")
    private boolean    credentialsNonExpired;
    
    @Column(name = "accountNonLocked")
    private boolean    accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

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
    
    public void addRole(Role role) {
        if(this.roles==null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
    }

}
