package com.beehive.beehiveNest.model.entities;

import com.beehive.beehiveNest.model.entities.address.Address;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Beehive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private AppUser owner;
}
