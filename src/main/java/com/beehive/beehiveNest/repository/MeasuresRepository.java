package com.beehive.beehiveNest.repository;

import com.beehive.beehiveNest.model.entities.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasuresRepository extends JpaRepository<Measure, Long> {
}
