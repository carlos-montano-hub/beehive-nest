package com.beehive.beehiveNest.model.mappers;

import com.beehive.beehiveNest.model.dtos.AppUserDto;
import com.beehive.beehiveNest.model.entities.AppUser;
import com.beehive.beehiveNest.model.forms.AppUserForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppUsersMapper {
    AppUsersMapper INSTANCE = Mappers.getMapper(AppUsersMapper.class);

    //    Entity -> Dto
    AppUserDto getDto(AppUser entity);

    //    Form -> Entity
    AppUser getEntity(AppUserForm form);
}
