package com.beehive.beehiveNest.model.mappers;

import com.beehive.beehiveNest.model.dtos.BeehiveDto;
import com.beehive.beehiveNest.model.entities.Beehive;
import com.beehive.beehiveNest.model.forms.BeehiveForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BeehivesMapper {
    BeehivesMapper INSTANCE = Mappers.getMapper(BeehivesMapper.class);

    //    Entity -> Dto
    BeehiveDto getDto(Beehive entity);

    //    Form -> Entity
    Beehive getEntity(BeehiveForm form);
}
