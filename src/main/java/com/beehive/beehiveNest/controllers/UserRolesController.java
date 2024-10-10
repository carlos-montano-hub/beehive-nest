package com.beehive.beehiveNest.controllers;

import com.beehive.beehiveNest.model.dtos.UserRoleDto;
import com.beehive.beehiveNest.model.forms.UserRoleForm;
import com.beehive.beehiveNest.services.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/states")
public class UserRolesController extends BaseController<UserRoleDto, UserRoleForm> {
    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        super(userRolesService);  // Injecting into the BaseController
        this.userRolesService = userRolesService;  // Injecting into the CountriesController as well
    }
}
