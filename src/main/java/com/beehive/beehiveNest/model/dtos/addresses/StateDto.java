package com.beehive.beehiveNest.model.dtos.addresses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class StateDto {
    private Long id;
    private String name;
    private CountryDto country;
}
