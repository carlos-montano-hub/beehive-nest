package com.beehive.beehiveNest.model.forms.addresses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class StateForm {
    private String name;
    private long countryId;
}
