package com.beehive.beehiveNest.repository;

import com.beehive.beehiveNest.model.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUser, Long> {
}
