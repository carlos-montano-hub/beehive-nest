package com.beehive.beehiveNest.model.dtos.addresses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AddressDto {
    private Long id;
    private double coordY;
    private double coordX;
    private CityDto city;
}
