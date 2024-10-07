package com.beehive.beehiveNest.services;

import com.beehive.beehiveNest.configuration.mappers.AddressesMapper;
import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.model.entities.address.Country;
import com.beehive.beehiveNest.repository.address.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {
    @Autowired
    private CountriesRepository countryRepository;
    @Autowired
    private AddressesMapper addressesMapper;


    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(addressesMapper::getDto)
                .toList();
    }

    public Optional<CountryDto> getCountryById(Long id) {
        return countryRepository.findById(id)
                .map(addressesMapper::getDto);
    }

    public CountryDto createCountry(CountryDto countryDto) {
        Country country = addressesMapper.getEntity(countryDto);
        Country savedCountry = countryRepository.save(country);
        return addressesMapper.getDto(savedCountry);
    }

    public Optional<CountryDto> updateCountry(Long id, CountryDto countryDto) {
        if (!countryRepository.existsById(id)) {
            return Optional.empty();
        }
        Country country = addressesMapper.getEntity(countryDto);
        country.setId(id);
        Country updatedCountry = countryRepository.save(country);
        return Optional.of(addressesMapper.getDto(updatedCountry));
    }

    public boolean deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            return false;
        }
        countryRepository.deleteById(id);
        return true;
    }
}
