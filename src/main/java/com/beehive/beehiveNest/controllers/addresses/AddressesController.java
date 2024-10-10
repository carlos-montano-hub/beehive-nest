package com.beehive.beehiveNest.controllers.addresses;

import com.beehive.beehiveNest.controllers.BaseController;
import com.beehive.beehiveNest.model.dtos.addresses.AddressDto;
import com.beehive.beehiveNest.model.forms.addresses.AddressForm;
import com.beehive.beehiveNest.services.addresses.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController extends BaseController<AddressDto, AddressForm> {
    private final AddressesService addressesService;

    @Autowired
    public AddressesController(AddressesService addressesService) {
        super(addressesService);  // Injecting into the BaseController
        this.addressesService = addressesService;  // Injecting into the controller as well
    }
}
