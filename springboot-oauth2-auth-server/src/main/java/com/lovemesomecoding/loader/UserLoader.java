package com.lovemesomecoding.loader;

import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovemesomecoding.model.Role;
import com.lovemesomecoding.model.RoleType;
import com.lovemesomecoding.model.User;
import com.lovemesomecoding.model.UserRole;
import com.lovemesomecoding.repository.UserRepository;
import com.lovemesomecoding.utils.ObjectMapperUtils;
import com.lovemesomecoding.utils.PasswordUtils;

/**
 * It implements Spring Boot’s CommandLineRunner so that it gets run after all the beans are created and registered.
 * 
 * @author folaukaveinga
 *
 */
@Profile({"local"})
public class UserLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        User user = new User();
        user.setId(1);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("folaudev@gmail.com");
        user.setEnabled(true);
        user.setPassword(PasswordUtils.hashPassword("Test1234!"));
        user.setUsername("folaudev");
        user.addRole(new UserRole(user, RoleType.USER));
        user.addRole(new UserRole(user, RoleType.ADMIN));

        User savedUser = userRepository.saveAndFlush(user);

        System.out.println("savedUser\n" + ObjectMapperUtils.toJson(savedUser));

        user = new User();
        user.setId(2);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("folaudev+2@gmail.com");
        user.setEnabled(true);
        user.setPassword(PasswordUtils.hashPassword("Test1234!"));
        user.setUsername("folaudev2");
        user.addRole(new UserRole(user, RoleType.USER));

        savedUser = userRepository.saveAndFlush(user);

        System.out.println("savedUser\n" + ObjectMapperUtils.toJson(savedUser));
        
        user = new User();
        user.setId(3);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("folaudev+3@gmail.com");
        user.setEnabled(true);
        user.setPassword(PasswordUtils.hashPassword("Test1234!"));
        user.setUsername("folaudev3");
        user.addRole(new UserRole(user, RoleType.ADMIN));

        savedUser = userRepository.saveAndFlush(user);

        System.out.println("savedUser\n" + ObjectMapperUtils.toJson(savedUser));
        
    }

}
