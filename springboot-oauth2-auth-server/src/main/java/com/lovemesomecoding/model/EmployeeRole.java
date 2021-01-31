package com.lovemesomecoding.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@Entity
@Table(name = "employee_role")
public class EmployeeRole extends Role {

    private static final long serialVersionUID = 1L;
}
