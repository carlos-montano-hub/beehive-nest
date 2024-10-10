package com.beehive.beehiveNest.services;

import com.beehive.beehiveNest.exceptions.DependencyNotFoundException;
import com.beehive.beehiveNest.model.dtos.BeehiveDto;
import com.beehive.beehiveNest.model.entities.AppUser;
import com.beehive.beehiveNest.model.entities.Beehive;
import com.beehive.beehiveNest.model.entities.address.Address;
import com.beehive.beehiveNest.model.forms.BeehiveForm;
import com.beehive.beehiveNest.model.mappers.BeehivesMapper;
import com.beehive.beehiveNest.repository.AppUsersRepository;
import com.beehive.beehiveNest.repository.BeehivesRepository;
import com.beehive.beehiveNest.repository.address.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeehivesService implements CrudService<BeehiveDto, BeehiveForm> {

    @Autowired
    private BeehivesMapper beehivesMapper;
    @Autowired
    private BeehivesRepository beehivesRepository;
    @Autowired
    private AddressesRepository addressesRepository;
    @Autowired
    private AppUsersRepository appUsersRepository;

    @Override
    public List<BeehiveDto> getAll() {
        return beehivesRepository.findAll().stream()
                .map(beehivesMapper::getDto)
                .toList();
    }

    @Override
    public Optional<BeehiveDto> getById(Long id) {
        return beehivesRepository.findById(id)
                .map(beehivesMapper::getDto);
    }

    @Override
    public BeehiveDto create(BeehiveForm form) {
        Beehive entity = beehivesMapper.getEntity(form);

        Address address = addressesRepository.findById(form.getAddressId())
                .orElseThrow(() -> new DependencyNotFoundException("Address with ID " + form.getAddressId() + " not found."));
        entity.setAddress(address);

        AppUser user = appUsersRepository.findById(form.getOwnerUserId())
                .orElseThrow(() -> new DependencyNotFoundException("User with ID " + form.getOwnerUserId() + " not found."));
        entity.setOwner(user);

        Beehive savedEntity = beehivesRepository.save(entity);
        return beehivesMapper.getDto(savedEntity);
    }

    @Override
    public Optional<BeehiveDto> update(Long id, BeehiveForm form) {
        if (!beehivesRepository.existsById(id)) {
            return Optional.empty();
        }
        Beehive entity = beehivesMapper.getEntity(form);

        Address address = addressesRepository.findById(form.getAddressId())
                .orElseThrow(() -> new DependencyNotFoundException("Address with ID " + form.getAddressId() + " not found."));
        entity.setAddress(address);

        AppUser user = appUsersRepository.findById(form.getOwnerUserId())
                .orElseThrow(() -> new DependencyNotFoundException("User with ID " + form.getOwnerUserId() + " not found."));
        entity.setOwner(user);

        entity.setId(id);
        Beehive updatedEntity = beehivesRepository.save(entity);
        return Optional.of(beehivesMapper.getDto(updatedEntity));
    }

    @Override
    public boolean delete(Long id) {
        if (!beehivesRepository.existsById(id)) {
            return false;
        }
        beehivesRepository.deleteById(id);
        return true;
    }
}
