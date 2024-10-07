package com.beehive.beehiveNest.model.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AppUserDto {
    private Long id;
    private String name;
    private Long phoneNumber;
    private String emailAddress;
    private Long roleId;
}

