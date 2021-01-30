package com.lovemesomecoding;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Slf4j
@RestController
@SpringBootApplication
public class SpringbootOauth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOauth2ClientApplication.class, args);
    }

    @Autowired
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

        OAuth2AuthorizedClient client = oAuth2AuthorizedClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());
        //
        // String accessToken = client.getAccessToken().getTokenValue();

        log.info("name={}, authorizedClientRegistrationId={}", oauthToken.getName(), oauthToken.getAuthorizedClientRegistrationId());

        if (client == null) {
            log.info("client is null");
        } else {
            log.info("client is not null");
            log.info("name={},acceTokenType={}, acceToken={}", client.getPrincipalName(), client.getAccessToken().getTokenType().getValue(), client.getAccessToken().getTokenValue());

            Github github = new Github(client.getAccessToken().getTokenValue());
            github.getProfile();

            // Profile profile = github.getProfile();
            //
            // log.info("profile={}", profile.toString());
        }

        return Collections.singletonMap("name", principal.getName());
    }

    @Bean
    @RequestScope
    public Facebook facebook(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
            if (clientRegistrationId.equals("facebook")) {
                OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId, oauthToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
            }
        }
        return new Facebook(accessToken);
    }

    // @Bean
    // @RequestScope
    // public Github github(OAuth2AuthorizedClientService clientService) {
    // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // String accessToken = null;
    // if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
    // OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
    // String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
    // if (clientRegistrationId.equals("github")) {
    // OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId, oauthToken.getName());
    // accessToken = client.getAccessToken().getTokenValue();
    // }
    // }
    // return new Github(accessToken);
    // }

}
