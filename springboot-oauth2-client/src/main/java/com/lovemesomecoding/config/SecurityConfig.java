package com.lovemesomecoding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // ...

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.cors().and().csrf().disable()
              .authorizeRequests()
                .antMatchers("/", "/error", "/webjars/**","/users/signup","/users/signin")
                .permitAll()
                .anyRequest().authenticated()
              .and().oauth2Login();
        // @formatter:on
    }

}
