package com.lovemesomecoding.loader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataLoader {

    @Bean
    public UserLoader userLoader() {
        return new UserLoader();
    }
}
