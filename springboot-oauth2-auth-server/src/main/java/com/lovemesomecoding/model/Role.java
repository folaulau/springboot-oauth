/*******************************************************************************
 * @ UserRole.java @ Project: SideCar Health Corporation
 *
 * Copyright (c) 2017 SideCar Health Corporation. - All Rights Reserved El Segundo, California, U.S.A.
 *
 * This software is the confidential and proprietary information of SideCar Health Corporation. ("Confidential
 * Information").
 *
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SideCar Corporation.
 *
 * Contributors: SideCar Health Corporation. - Software Engineering Team
 ******************************************************************************/
package com.lovemesomecoding.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(value = Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    protected Long            id;

    @Column(name = "authority", nullable = false, updatable = false)
    protected String          authority;

    public Role(String authority) {
        super();
        this.authority = authority;
    }

}
