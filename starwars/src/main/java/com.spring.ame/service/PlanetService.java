package com.spring.ame.service;

import com.spring.ame.domain.Planet;
import com.spring.ame.dto.PlanetApiSwapiDTO;
import com.spring.ame.dto.PlanetApiSwapiResults;
import com.spring.ame.dto.PlanetDTO;
import com.spring.ame.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class PlanetService {

    final static String HOST = "https://swapi.co" ;
    final static String PATH = "/api/planets/" ;
    final static String SEARCH = "search";

    @Autowired
    private PlanetRepository planetRepository;

    public Planet fromDTO(PlanetDTO planetDTO) {
        return new Planet(planetDTO.getId(), planetDTO.getName(), planetDTO.getClimate(), planetDTO.getTerrain(), calculateAmountOfMovies(planetDTO.getName()));
    }

    public int calculateAmountOfMovies(String planetName) {
        PlanetApiSwapiDTO planetApiSwapiDTO = callGetPlanet(planetName);
        List<PlanetApiSwapiResults> planetApiSwapiResults = planetApiSwapiDTO.getResults();

        return planetApiSwapiResults.stream().filter(x -> x.getName().equalsIgnoreCase(planetName))
                .mapToInt(x -> x.getFilms().size()).sum();
    }

    public PlanetApiSwapiDTO callGetPlanet (String planetName) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl(HOST)
                .path(PATH)
                .queryParam(SEARCH, planetName)
                .build().toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).header(HttpHeaders.USER_AGENT,"PostmanRuntime/7.21.0")
                .accept(MediaType.APPLICATION_JSON).build();                ;

        ResponseEntity<PlanetApiSwapiDTO> result =
                restTemplate.exchange(request, new ParameterizedTypeReference< PlanetApiSwapiDTO> (){});

        return result.getBody();
    }

    public Planet insertPlanets(Planet planet) {
        planet.setId(null);
        return planetRepository.save(planet);
    }

    public void deletePlanet(Integer id) {
        planetRepository.deleteById(id);
    }

    public Optional<Planet> find(Integer id) {
        return planetRepository.findById(id);
    }

    public Planet findByName(String name) {
        return planetRepository.findByName(name);
    }

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }
}

