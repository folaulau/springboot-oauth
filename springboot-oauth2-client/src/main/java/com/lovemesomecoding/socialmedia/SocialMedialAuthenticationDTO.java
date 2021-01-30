package com.lovemesomecoding.socialmedia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SocialMedialAuthenticationDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            code;
    // Facebook, Google, or Github
    private String            platform;
}
