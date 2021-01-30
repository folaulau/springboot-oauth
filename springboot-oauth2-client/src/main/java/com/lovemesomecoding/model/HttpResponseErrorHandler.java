package com.lovemesomecoding.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class HttpResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) {
        try {
            log.info("===========================Http Error Response begin============================================");
            log.info("Status code  : {}", response.getStatusCode());
            log.info("Status text  : {}", response.getStatusText());
            log.info("Headers      : {}", response.getHeaders());
            log.info("Response body: {}", ObjectMapperUtils.getObjectMapper().writeValueAsString(response.getBody()));
            log.info("===========================Http Error Response end==============================================");
        } catch (Exception e) {
            log.error("Exception msg: {}", e.getMessage(), e);
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) {
        if (log.isInfoEnabled()) {
            try {
                log.info("===========================Http HandleError Response begin============================================");
                log.info("Status code  :{}", response.getStatusCode());
                log.info("Status text  :{}", response.getStatusText());
                log.info("Headers      :{}", response.getHeaders());

                InputStream inputStream = response.getBody();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder out = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    out.append(line);
                }
                reader.close();

                log.info("Response body: {}", out.toString());
                log.info("===========================Http HandleError Response end==============================================");
            } catch (Exception e) {
                log.error("Exception msg: {}", e.getMessage(), e);
            }
        }
    }

}
