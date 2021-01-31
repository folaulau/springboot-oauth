package com.lovemesomecoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {

    /**
     * 
     */
    private static final long  serialVersionUID = 1L;

    public static final String ALL              = "ALL";//1
    public static final String READ             = "READ";//2
    public static final String WRITE            = "WRITE";//3
    public static final String DELETE           = "DELETE";//4
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long            id;

    @Column(name = "name")
    private String             name;

    public Permission(long id) {
        this.id = id;
    }

}
