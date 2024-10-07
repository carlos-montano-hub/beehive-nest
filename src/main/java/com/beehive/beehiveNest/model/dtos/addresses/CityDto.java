package com.beehive.beehiveNest.model.dtos.addresses;

import com.beehive.beehiveNest.model.entities.address.State;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CityDto {
    private Long id;
    private String name;
    private State state;
}
