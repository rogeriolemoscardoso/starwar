package com.spring.ame.resource;


import com.spring.ame.domain.Planet;
import com.spring.ame.dto.PlanetDTO;
import com.spring.ame.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/planets")
public class PlanetResource {

    @Autowired
    private PlanetService planetService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> insertPlanet(@RequestBody PlanetDTO planetDTO) {
        Planet planet = planetService.fromDTO(planetDTO);
        planet = planetService.insertPlanets(planet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
                path("/{id}").buildAndExpand(planet.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Planet>> findById(@PathVariable Integer id) {
            Optional<Planet> planet= planetService.find(id);
        return ResponseEntity.ok().body(planet);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Planet> findByName(@PathVariable String name) {
        Planet planet = planetService.findByName(name);
        return ResponseEntity.ok().body(planet);
    }

    @RequestMapping(method = RequestMethod.GET)
    public  ResponseEntity<List<Planet>> findAll () {
        List<Planet> planets = planetService.findAll();
        return ResponseEntity.ok().body(planets);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePlanet(@PathVariable Integer id) {
        planetService.deletePlanet(id);
        return ResponseEntity.noContent().build();
    }
}
