package com.beehive.beehiveNest.repository.address;

import com.beehive.beehiveNest.model.entities.address.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<City, Long> {
}
