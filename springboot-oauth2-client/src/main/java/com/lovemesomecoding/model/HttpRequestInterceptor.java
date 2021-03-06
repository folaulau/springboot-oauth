package com.lovemesomecoding.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class HttpRequestInterceptor implements ClientHttpRequestInterceptor {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		logResponse(response);
		return response;
	}

	private void logRequest(HttpRequest request, byte[] body) throws IOException {
		if (log.isInfoEnabled()) {
			try {
				System.out.println();
				System.out.println(
						"===========================Http Request begin=============================================");
				log.info("URI         :" + request.getURI());
				log.info("Method      :" + request.getMethod());
				log.info("Headers     :" + request.getHeaders());
				log.info("Request body:" + new String(body, "UTF-8"));
				System.out.println(
						"===========================Http Request end===============================================");
				System.out.println();
			} catch (Exception e) {
				log.warn("Exception msg: {}", e.getMessage());
			}

		}
	}

	private String logResponse(ClientHttpResponse response) throws IOException {
		StringBuilder result = new StringBuilder();

		if (log.isInfoEnabled()) {

			try {
				System.out.println();
				System.out.println(
						"===========================Http Response begin============================================");
				log.info("Status code  :" + response.getStatusCode());
				log.info("Status code value  :" + response.getStatusCode().value());
				log.info("Headers      :" + response.getHeaders());

			} catch (Exception e) {
				log.warn("Exception msg: {}", e.getMessage());
			}

			try {
				InputStream inputStream = response.getBody();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder out = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					out.append(line);
				}
				reader.close();

				log.info("Response body: " + out.toString());
				System.out.println(
						"===========================Http Response end==============================================");
				System.out.println();

				result.append(out.toString());
			} catch (Exception e) {
				log.warn("Exception msg: {}", e.getMessage());
				result.append(e.getLocalizedMessage());
			}

		}
		return result.toString();
	}

}
