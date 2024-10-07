package com.beehive.beehiveNest.repository.address;

import com.beehive.beehiveNest.model.entities.address.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<State, Long> {
}
