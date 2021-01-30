package com.lovemesomecoding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lovemesomecoding.Github;
import com.lovemesomecoding.model.ObjectMapperUtils;
import com.lovemesomecoding.model.User;
import com.lovemesomecoding.socialmedia.AccessTokenDTO;
import com.lovemesomecoding.socialmedia.SocialMedialAuthenticationDTO;

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

    @GetMapping("/signup")
    public ResponseEntity<User> signup(@PathVariable String uuid) {
        log.info("getByUuid({})", uuid);
        User user = new User("test", "test");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<User> signin(@RequestBody SocialMedialAuthenticationDTO socialMedialAuth) {
        log.info("signin({})", ObjectMapperUtils.toJson(socialMedialAuth));

        Github github = new Github("asdfasd");
        AccessTokenDTO accessToken = github.getAccessToken(socialMedialAuth.getCode());
        log.info("accessToken ={}", ObjectMapperUtils.toJson(accessToken));

        github = new Github(accessToken.getAccessToken());
        ObjectNode profile = github.getProfile();
        log.info("profile ={}", ObjectMapperUtils.toJson(profile));

        User user = new User("test", "test");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
