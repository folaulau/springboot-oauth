package com.lovemesomecoding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovemesomecoding.model.User;

@RequestMapping("/users")
@RestController
public class UserRestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{uuid}")
    public ResponseEntity<User> getByUuid(@PathVariable String uuid) {
        log.info("getByUuid({})", uuid);
        User user = new User("test", "test");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
