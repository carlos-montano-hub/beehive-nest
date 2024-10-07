package com.beehive.beehiveNest.controllers.addresses;

import com.beehive.beehiveNest.controllers.BaseController;
import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.model.dtos.addresses.StateDto;
import com.beehive.beehiveNest.model.forms.addresses.CountryForm;
import com.beehive.beehiveNest.model.forms.addresses.StateForm;
import com.beehive.beehiveNest.services.addresses.CountriesService;
import com.beehive.beehiveNest.services.addresses.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/states")
public class StatesController extends BaseController<StateDto, StateForm> {
    private final StatesService statesService;

    @Autowired
    public StatesController(StatesService statesService) {
        super(statesService);  // Injecting into the BaseController
        this.statesService = statesService;  // Injecting into the CountriesController as well
    }
}
