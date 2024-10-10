package com.beehive.beehiveNest.controllers;

import com.beehive.beehiveNest.model.dtos.BeehiveDto;
import com.beehive.beehiveNest.model.forms.BeehiveForm;
import com.beehive.beehiveNest.services.BeehivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/beehives")
public class BeehiveController extends BaseController<BeehiveDto, BeehiveForm> {
    private final BeehivesService beehivesService;

    @Autowired
    public BeehiveController(BeehivesService service) {
        super(service);  // Injecting into the BaseController
        this.beehivesService = service;  // Injecting into the controller as well
    }
}
