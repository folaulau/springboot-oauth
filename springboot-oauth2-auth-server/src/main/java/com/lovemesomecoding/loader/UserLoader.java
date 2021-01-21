package com.lovemesomecoding.loader;

import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.model.User;
import com.lovemesomecoding.repository.UserRepository;

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

        // userRepository.saveAndFlush(user);
    }

}
