package com.beehive.beehiveNest.model.forms.addresses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CityForm {
    private String name;
    private long stateId;
}
