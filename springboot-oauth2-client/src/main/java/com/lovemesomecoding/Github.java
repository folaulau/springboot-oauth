package com.lovemesomecoding;

import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lovemesomecoding.socialmedia.AccessTokenDTO;

public class Github extends ApiBinding {

    private static final String API_BASE_URL = "https://api.github.com";

    public Github() {
        this.restTemplate = new RestTemplate();

    }

    public Github(String accessToken) {
        super(accessToken);
    }

    public ObjectNode getProfile() {
        return restTemplate.getForObject(API_BASE_URL + "/user", ObjectNode.class);
    }

    public AccessTokenDTO getAccessToken(String code) {

        try {
            
            String clientId = "";
            String clientSecret = "";

            ResponseEntity<AccessTokenDTO> response = restTemplate.exchange(
                    new URI("https://github.com/login/oauth/access_token?client_id="+clientId+"&client_secret="+clientSecret+"&code=" + code), HttpMethod.POST, null,
                    AccessTokenDTO.class);

            AccessTokenDTO accessToken = response.getBody();

            return accessToken;

        } catch (Exception e) {
            System.err.println("Exception, msg=" + e.getLocalizedMessage());
            return null;
        }

    }

}
