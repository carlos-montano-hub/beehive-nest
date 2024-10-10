package com.beehive.beehiveNest.model.dtos;

import com.beehive.beehiveNest.model.dtos.addresses.AddressDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BeehiveDto {
    private Long id;
    private String name;
    private AddressDto address;
    private AppUserDto ownerUser;
}
