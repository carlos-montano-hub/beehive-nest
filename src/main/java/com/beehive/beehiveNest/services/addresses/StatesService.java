package com.beehive.beehiveNest.services.addresses;

import com.beehive.beehiveNest.configuration.mappers.AddressesMapper;
import com.beehive.beehiveNest.exceptions.DependencyNotFoundException;
import com.beehive.beehiveNest.model.dtos.addresses.StateDto;
import com.beehive.beehiveNest.model.entities.address.Country;
import com.beehive.beehiveNest.model.entities.address.State;
import com.beehive.beehiveNest.model.forms.addresses.StateForm;
import com.beehive.beehiveNest.repository.address.CountriesRepository;
import com.beehive.beehiveNest.repository.address.StatesRepository;
import com.beehive.beehiveNest.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesService implements CrudService<StateDto, StateForm> {
    @Autowired
    private StatesRepository statesRepository;
    @Autowired
    private CountriesRepository countriesRepository;
    @Autowired
    private AddressesMapper addressesMapper;

    @Override
    public List<StateDto> getAll() {
        return statesRepository.findAll().stream()
                .map(addressesMapper::getDto)
                .toList();
    }

    @Override
    public Optional<StateDto> getById(Long id) {
        return statesRepository.findById(id)
                .map(addressesMapper::getDto);
    }

    @Override
    public StateDto create(StateForm stateForm) {
        State state = addressesMapper.getEntity(stateForm);
        Country country = countriesRepository.findById(stateForm.getCountryId())
                .orElseThrow(() -> new DependencyNotFoundException("Country with ID " + stateForm.getCountryId() + " not found."));
        state.setCountry(country);
        State savedState = statesRepository.save(state);
        return addressesMapper.getDto(savedState);
    }

    @Override
    public Optional<StateDto> update(Long id, StateForm stateForm) {
        if (!statesRepository.existsById(id)) {
            return Optional.empty();
        }
        State state = addressesMapper.getEntity(stateForm);
        Country country = countriesRepository.findById(stateForm.getCountryId())
                .orElseThrow(() -> new DependencyNotFoundException("Country with ID " + stateForm.getCountryId() + " not found."));
        state.setCountry(country);
        state.setId(id);
        State updatedState = statesRepository.save(state);
        return Optional.of(addressesMapper.getDto(updatedState));
    }

    @Override
    public boolean delete(Long id) {
        if (!statesRepository.existsById(id)) {
            return false;
        }
        statesRepository.deleteById(id);
        return true;
    }
}
