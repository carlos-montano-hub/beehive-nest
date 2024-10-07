package com.beehive.beehiveNest.model.forms.addresses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AddressForm {
    private double coordY;
    private double coordX;
    private long cityId;
}
