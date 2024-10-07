package com.beehive.beehiveNest.model.dtos;

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
    private Long addressId;
    private Long ownerUserId;
}
