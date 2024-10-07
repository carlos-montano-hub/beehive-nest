package com.beehive.beehiveNest.controllers.addresses;

import com.beehive.beehiveNest.controllers.BaseController;
import com.beehive.beehiveNest.model.dtos.addresses.CityDto;
import com.beehive.beehiveNest.model.forms.addresses.CityForm;
import com.beehive.beehiveNest.services.addresses.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CitiesController extends BaseController<CityDto, CityForm> {
    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        super(citiesService);  // Injecting into the BaseController
        this.citiesService = citiesService;  // Injecting into the CountriesController as well
    }
}
