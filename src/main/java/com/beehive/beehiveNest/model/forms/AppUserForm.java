package com.beehive.beehiveNest.model.forms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AppUserForm {
    private String name;
    private Long phoneNumber;
    private String emailAddress;
    private long roleId;
}

