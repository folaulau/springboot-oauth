package com.lovemesomecoding;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Github extends ApiBinding {

    private static final String API_BASE_URL = "https://api.github.com";

    public Github(String accessToken) {
        super(accessToken);
    }

    public ObjectNode getProfile() {
        return restTemplate.getForObject(API_BASE_URL + "/user", ObjectNode.class);
    }

}
