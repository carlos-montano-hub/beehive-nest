package com.beehive.beehiveNest.model.mappers;

import com.beehive.beehiveNest.model.dtos.addresses.AddressDto;
import com.beehive.beehiveNest.model.dtos.addresses.CityDto;
import com.beehive.beehiveNest.model.dtos.addresses.CountryDto;
import com.beehive.beehiveNest.model.dtos.addresses.StateDto;
import com.beehive.beehiveNest.model.entities.address.Address;
import com.beehive.beehiveNest.model.entities.address.City;
import com.beehive.beehiveNest.model.entities.address.Country;
import com.beehive.beehiveNest.model.entities.address.State;
import com.beehive.beehiveNest.model.forms.addresses.AddressForm;
import com.beehive.beehiveNest.model.forms.addresses.CityForm;
import com.beehive.beehiveNest.model.forms.addresses.CountryForm;
import com.beehive.beehiveNest.model.forms.addresses.StateForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressesMapper {
    AddressesMapper INSTANCE = Mappers.getMapper(AddressesMapper.class);

    //    Entity -> Dto
    CountryDto getDto(Country entity);

    StateDto getDto(State entity);

    CityDto getDto(City entity);

    AddressDto getDto(Address entity);

    //    Form -> Entity
    Country getEntity(CountryForm form);

    State getEntity(StateForm form);

    City getEntity(CityForm form);

    Address getEntity(AddressForm form);
}
