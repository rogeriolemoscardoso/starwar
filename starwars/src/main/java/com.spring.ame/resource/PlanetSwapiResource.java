package com.spring.ame.resource;

import com.spring.ame.service.PlanetSwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(value = "/swapi")
public class PlanetSwapiResource {

    @Autowired
    PlanetSwapiService planetSwapiService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findAllSWAPI (@PathVariable Integer  id) {
        Map<String,Object> planetsPage = planetSwapiService.findPlanetPage(id);
        return ResponseEntity.ok().body(planetsPage);
    }
}
