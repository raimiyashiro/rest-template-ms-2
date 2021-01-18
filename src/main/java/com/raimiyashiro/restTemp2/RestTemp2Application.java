package com.raimiyashiro.restTemp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class RestTemp2Application {

    public static void main(String[] args) {
        SpringApplication.run(RestTemp2Application.class, args);
        RestTemplate restTemplate = new RestTemplate();

        String foo = "http://localhost:8080/foo/exception/2";
        ResponseEntity<String> res = null;

        try {
            res = restTemplate.getForEntity(foo, String.class);
        } catch (HttpClientErrorException e) {
            // Bad Requests
            e.printStackTrace();
        } catch (RestClientException e) {
            // Cannot extract response type
            e.printStackTrace();
        }

        if (res == null) {
            // When the server throws an Exception, response is null
        } else {
            System.out.println(res);
        }
    }

}
