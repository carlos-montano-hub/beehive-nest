package com.beehive.beehiveNest.controllers;

import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countries = countriesService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        return countriesService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        CountryDto createdCountry = countriesService.createCountry(countryDto);
        return ResponseEntity.status(200).body(createdCountry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return countriesService.updateCountry(id, countryDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        return countriesService.deleteCountry(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
