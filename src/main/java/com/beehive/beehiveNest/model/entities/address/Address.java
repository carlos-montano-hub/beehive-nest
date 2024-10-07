package com.beehive.beehiveNest.model.entities.address;

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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double coordY;
    private double coordX;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
