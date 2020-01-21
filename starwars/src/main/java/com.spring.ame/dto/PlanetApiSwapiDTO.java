package com.spring.ame.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetApiSwapiDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private List<PlanetApiSwapiResults> results;

    public List<PlanetApiSwapiResults> getResults() {
        return results;
    }

}
