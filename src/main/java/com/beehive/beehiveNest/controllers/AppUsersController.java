package com.beehive.beehiveNest.controllers;

import com.beehive.beehiveNest.model.dtos.AppUserDto;
import com.beehive.beehiveNest.model.forms.AppUserForm;
import com.beehive.beehiveNest.services.AppUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appUsers")
public class AppUsersController extends BaseController<AppUserDto, AppUserForm> {
    private final AppUsersService appUsersService;

    @Autowired
    public AppUsersController(AppUsersService service) {
        super(service);  // Injecting into the BaseController
        this.appUsersService = service;  // Injecting into the CountriesController as well
    }
}
