package com.beehive.beehiveNest.configuration.mappers;

import com.beehive.beehiveNest.model.dtos.addresses.AddressDto;
import com.beehive.beehiveNest.model.dtos.addresses.CityDto;
import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.model.dtos.addresses.StateDto;
import com.beehive.beehiveNest.model.entities.address.Address;
import com.beehive.beehiveNest.model.entities.address.City;
import com.beehive.beehiveNest.model.entities.address.Country;
import com.beehive.beehiveNest.model.entities.address.State;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressesMapper {
    AddressesMapper INSTANCE = Mappers.getMapper(AddressesMapper.class);

    CountryDto getDto(Country entity);

    StateDto getDto(State entity);

    CityDto getDto(City entity);

    AddressDto getDto(Address entity);

    Country getEntity(CountryDto dto);

    State getEntity(StateDto dto);

    City getEntity(CityDto dto);

    Address getEntity(AddressDto dto);
}
