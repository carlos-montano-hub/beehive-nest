package com.beehive.beehiveNest.services.addresses;

import com.beehive.beehiveNest.exceptions.DependencyNotFoundException;
import com.beehive.beehiveNest.model.dtos.addresses.CityDto;
import com.beehive.beehiveNest.model.entities.address.City;
import com.beehive.beehiveNest.model.entities.address.State;
import com.beehive.beehiveNest.model.forms.addresses.CityForm;
import com.beehive.beehiveNest.model.mappers.AddressesMapper;
import com.beehive.beehiveNest.repository.address.CitiesRepository;
import com.beehive.beehiveNest.repository.address.StatesRepository;
import com.beehive.beehiveNest.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService implements CrudService<CityDto, CityForm> {
    @Autowired
    private CitiesRepository citiesRepository;
    @Autowired
    private StatesRepository statesRepository;
    @Autowired
    private AddressesMapper addressesMapper;

    @Override
    public List<CityDto> getAll() {
        return citiesRepository.findAll().stream()
                .map(addressesMapper::getDto)
                .toList();
    }

    @Override
    public Optional<CityDto> getById(Long id) {
        return citiesRepository.findById(id)
                .map(addressesMapper::getDto);
    }

    @Override
    public CityDto create(CityForm cityForm) {
        State state = statesRepository.findById(cityForm.getStateId())
                .orElseThrow(() -> new DependencyNotFoundException("State with ID " + cityForm.getStateId() + " not found."));
        City city = addressesMapper.getEntity(cityForm);
        city.setState(state);
        City savedCity = citiesRepository.save(city);
        return addressesMapper.getDto(savedCity);
    }

    @Override
    public Optional<CityDto> update(Long id, CityForm cityForm) {
        if (!citiesRepository.existsById(id)) {
            return Optional.empty();
        }
        City city = addressesMapper.getEntity(cityForm);
        city.setId(id);
        City updatedCity = citiesRepository.save(city);
        return Optional.of(addressesMapper.getDto(updatedCity));
    }

    @Override
    public boolean delete(Long id) {
        if (!citiesRepository.existsById(id)) {
            return false;
        }
        citiesRepository.deleteById(id);
        return true;
    }
}
