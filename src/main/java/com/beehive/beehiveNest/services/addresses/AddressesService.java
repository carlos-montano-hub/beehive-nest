package com.beehive.beehiveNest.services.addresses;

import com.beehive.beehiveNest.configuration.mappers.AddressesMapper;
import com.beehive.beehiveNest.exceptions.DependencyNotFoundException;
import com.beehive.beehiveNest.model.dtos.addresses.AddressDto;
import com.beehive.beehiveNest.model.entities.address.Address;
import com.beehive.beehiveNest.model.entities.address.City;
import com.beehive.beehiveNest.model.forms.addresses.AddressForm;
import com.beehive.beehiveNest.repository.address.AddressesRepository;
import com.beehive.beehiveNest.repository.address.CitiesRepository;
import com.beehive.beehiveNest.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressesService implements CrudService<AddressDto, AddressForm> {
    @Autowired
    private CitiesRepository citiesRepository;
    @Autowired
    private AddressesRepository addressesRepository;
    @Autowired
    private AddressesMapper addressesMapper;

    @Override
    public List<AddressDto> getAll() {
        return addressesRepository.findAll().stream()
                .map(addressesMapper::getDto)
                .toList();
    }

    @Override
    public Optional<AddressDto> getById(Long id) {
        return addressesRepository.findById(id)
                .map(addressesMapper::getDto);
    }

    @Override
    public AddressDto create(AddressForm addressForm) {
        City city = citiesRepository.findById(addressForm.getCityId())
                .orElseThrow(() -> new DependencyNotFoundException("City with ID " + addressForm.getCityId() + " not found."));
        Address address = addressesMapper.getEntity(addressForm);
        address.setCity(city);
        Address savedAddress = addressesRepository.save(address);
        return addressesMapper.getDto(savedAddress);
    }

    @Override
    public Optional<AddressDto> update(Long id, AddressForm addressForm) {
        if (!addressesRepository.existsById(id)) {
            return Optional.empty();
        }
        Address address = addressesMapper.getEntity(addressForm);
        address.setId(id);
        Address updatedAddress = addressesRepository.save(address);
        return Optional.of(addressesMapper.getDto(updatedAddress));
    }

    @Override
    public boolean delete(Long id) {
        if (!addressesRepository.existsById(id)) {
            return false;
        }
        addressesRepository.deleteById(id);
        return true;
    }
}
