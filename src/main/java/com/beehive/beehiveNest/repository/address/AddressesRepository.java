package com.beehive.beehiveNest.repository.address;

import com.beehive.beehiveNest.model.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Long> {
}
