package com.beehive.beehiveNest.model.forms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BeehiveForm {
    private String name;
    private Long addressId;
    private Long ownerUserId;
}
