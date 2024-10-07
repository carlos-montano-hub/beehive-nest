package com.beehive.beehiveNest.services.addresses;

import com.beehive.beehiveNest.configuration.mappers.AddressesMapper;
import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.model.entities.address.Country;
import com.beehive.beehiveNest.model.forms.addresses.CountryForm;
import com.beehive.beehiveNest.repository.address.CountriesRepository;
import com.beehive.beehiveNest.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService implements CrudService<CountryDto, CountryForm> {
    @Autowired
    private CountriesRepository countryRepository;
    @Autowired
    private AddressesMapper addressesMapper;

    @Override
    public List<CountryDto> getAll() {
        return countryRepository.findAll().stream()
                .map(addressesMapper::getDto)
                .toList();
    }

    @Override
    public Optional<CountryDto> getById(Long id) {
        return countryRepository.findById(id)
                .map(addressesMapper::getDto);
    }

    @Override
    public CountryDto create(CountryForm countryForm) {
        Country country = addressesMapper.getEntity(countryForm);
        Country savedCountry = countryRepository.save(country);
        return addressesMapper.getDto(savedCountry);
    }

    @Override
    public Optional<CountryDto> update(Long id, CountryForm countryForm) {
        if (!countryRepository.existsById(id)) {
            return Optional.empty();
        }
        Country country = addressesMapper.getEntity(countryForm);
        country.setId(id);
        Country updatedCountry = countryRepository.save(country);
        return Optional.of(addressesMapper.getDto(updatedCountry));
    }

    @Override
    public boolean delete(Long id) {
        if (!countryRepository.existsById(id)) {
            return false;
        }
        countryRepository.deleteById(id);
        return true;
    }
}
