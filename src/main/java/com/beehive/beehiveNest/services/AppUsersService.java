package com.beehive.beehiveNest.services;

import com.beehive.beehiveNest.exceptions.DependencyNotFoundException;
import com.beehive.beehiveNest.model.dtos.AppUserDto;
import com.beehive.beehiveNest.model.entities.AppUser;
import com.beehive.beehiveNest.model.entities.UserRole;
import com.beehive.beehiveNest.model.forms.AppUserForm;
import com.beehive.beehiveNest.model.mappers.AppUsersMapper;
import com.beehive.beehiveNest.repository.AppUsersRepository;
import com.beehive.beehiveNest.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUsersService implements CrudService<AppUserDto, AppUserForm> {

    @Autowired
    private AppUsersMapper appUsersMapper;
    @Autowired
    private AppUsersRepository appUsersRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public List<AppUserDto> getAll() {
        return appUsersRepository.findAll().stream()
                .map(appUsersMapper::getDto)
                .toList();
    }

    @Override
    public Optional<AppUserDto> getById(Long id) {
        return appUsersRepository.findById(id)
                .map(appUsersMapper::getDto);
    }

    @Override
    public AppUserDto create(AppUserForm form) {
        AppUser entity = appUsersMapper.getEntity(form);

        UserRole role = userRolesRepository.findById(form.getRoleId())
                .orElseThrow(() -> new DependencyNotFoundException("User Role with ID " + form.getRoleId() + " not found."));
        entity.setRole(role);

        AppUser savedEntity = appUsersRepository.save(entity);
        return appUsersMapper.getDto(savedEntity);
    }

    @Override
    public Optional<AppUserDto> update(Long id, AppUserForm form) {
        if (!appUsersRepository.existsById(id)) {
            return Optional.empty();
        }
        AppUser entity = appUsersMapper.getEntity(form);
        UserRole role = userRolesRepository.findById(form.getRoleId())
                .orElseThrow(() -> new DependencyNotFoundException("User Role with ID " + form.getRoleId() + " not found."));
        entity.setRole(role);
        entity.setId(id);
        AppUser updatedEntity = appUsersRepository.save(entity);
        return Optional.of(appUsersMapper.getDto(updatedEntity));
    }

    @Override
    public boolean delete(Long id) {
        if (!appUsersRepository.existsById(id)) {
            return false;
        }
        appUsersRepository.deleteById(id);
        return true;
    }
}
