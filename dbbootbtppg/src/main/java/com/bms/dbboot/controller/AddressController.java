package com.bms.dbboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dbboot.entities.Address;
import com.bms.dbboot.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class AddressController {
    @Autowired
    AddressService addressSrv;

    @RequestMapping("/addressess")
    public List<Address> getAddresses() {
        return addressSrv.getAddresses();
    }

    @RequestMapping("/address/{addressId}")
    public Optional<Address> getAddressById(@PathVariable("addressId") String addressId) {
        return addressSrv.getSingleAddress(addressId);
    }
    

    @PostMapping("/addresss")
    public Address createAddress(@RequestBody Address payload) {
        return addressSrv.createAddress(payload);
    }
    
    
}
