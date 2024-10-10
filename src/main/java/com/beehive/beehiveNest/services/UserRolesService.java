package com.beehive.beehiveNest.services;

import com.beehive.beehiveNest.model.dtos.UserRoleDto;
import com.beehive.beehiveNest.model.entities.UserRole;
import com.beehive.beehiveNest.model.forms.UserRoleForm;
import com.beehive.beehiveNest.model.mappers.UserRolesMapper;
import com.beehive.beehiveNest.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolesService implements CrudService<UserRoleDto, UserRoleForm> {

    @Autowired
    private UserRolesMapper userRolesMapper;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public List<UserRoleDto> getAll() {
        return userRolesRepository.findAll().stream()
                .map(userRolesMapper::getDto)
                .toList();
    }

    @Override
    public Optional<UserRoleDto> getById(Long id) {
        return userRolesRepository.findById(id)
                .map(userRolesMapper::getDto);
    }

    @Override
    public UserRoleDto create(UserRoleForm form) {
        UserRole entity = userRolesMapper.getEntity(form);
        UserRole savedEntity = userRolesRepository.save(entity);
        return userRolesMapper.getDto(savedEntity);
    }

    @Override
    public Optional<UserRoleDto> update(Long id, UserRoleForm form) {
        if (!userRolesRepository.existsById(id)) {
            return Optional.empty();
        }
        UserRole entity = userRolesMapper.getEntity(form);
        entity.setId(id);
        UserRole updatedEntity = userRolesRepository.save(entity);
        return Optional.of(userRolesMapper.getDto(updatedEntity));
    }

    @Override
    public boolean delete(Long id) {
        if (!userRolesRepository.existsById(id)) {
            return false;
        }
        userRolesRepository.deleteById(id);
        return true;
    }
}
