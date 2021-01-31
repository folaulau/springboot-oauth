package com.lovemesomecoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {

    /**
     * 
     */
    private static final long  serialVersionUID = 1L;

    public static final String ADMIN            = "ADMIN";//1
    public static final String USER             = "USER";//2

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long               id;
    
    @Column(name = "name")
    private String             name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "permission_role", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission>   permissions;

    public Role(long id, Permission... permissions) {
        this.id = id;
        for (Permission permission : permissions) {
            this.addPermission(permission);
        }
    }

    public void addPermission(Permission permission) {
        if (this.permissions == null) {
            this.permissions = new ArrayList<>();
        }
        this.permissions.add(permission);
    }

}
