package com.beehive.beehiveNest.controllers.addresses;

import com.beehive.beehiveNest.controllers.BaseController;
import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.model.forms.addresses.CountryForm;
import com.beehive.beehiveNest.services.addresses.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountriesController extends BaseController<CountryDto, CountryForm> {
    private final CountriesService countriesService;

    @Autowired
    public CountriesController(CountriesService countriesService) {
        super(countriesService);  // Injecting into the BaseController
        this.countriesService = countriesService;  // Injecting into the CountriesController as well
    }
}
