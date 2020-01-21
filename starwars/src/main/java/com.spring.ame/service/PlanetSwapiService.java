package com.spring.ame.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Service
public class PlanetSwapiService {

    final static String HOST = "https://swapi.co" ;
    final static String PATH = "/api/planets/" ;
    final static String PAGE = "page";
    final static String USER_AGENT_VALUE = "PostmanRuntime/7.21.0";

    public Map<String, Object> findPlanetPage(Integer pag) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl(HOST)
                .path(PATH)
                .queryParam(PAGE, pag)
                .build().toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).header(HttpHeaders.USER_AGENT,USER_AGENT_VALUE)
                .accept(MediaType.APPLICATION_JSON).build();

        ResponseEntity<Map<String, Object>> result =
                restTemplate.exchange(request, new ParameterizedTypeReference< Map<String, Object>>(){});

        return result.getBody();
    }
}
