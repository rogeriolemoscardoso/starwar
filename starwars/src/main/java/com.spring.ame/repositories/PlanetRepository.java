package com.spring.ame.repositories;

import com.spring.ame.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlanetRepository  extends JpaRepository<Planet,Integer> {

    @Transactional(readOnly = true)
    Planet findByName(String name);

}
