package com.beehive.beehiveNest.repository.address;

import com.beehive.beehiveNest.model.entities.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Long> {
}
