package com.spring.ame.dto;

import com.spring.ame.domain.Planet;

public class PlanetDTO {

    private Integer id;
    private String name;
    private String climate;
    private String terrain;

    public PlanetDTO() {
    }

    public PlanetDTO(Planet planet) {
        this.id = planet.getId();
        this.name = planet.getName();
        this.terrain = planet.getTerrain();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}
