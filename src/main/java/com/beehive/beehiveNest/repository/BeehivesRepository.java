package com.beehive.beehiveNest.repository;

import com.beehive.beehiveNest.model.entities.Beehive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeehivesRepository extends JpaRepository<Beehive, Long> {
}