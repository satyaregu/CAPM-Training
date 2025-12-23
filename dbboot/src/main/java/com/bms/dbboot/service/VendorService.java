package com.bms.dbboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.dbboot.entities.Vendor;

@Component
public class VendorService {

@Autowired    
IVendorPersistence vendorDB;    

//Read all vendors - Returns an internal table
public List<Vendor> getAllVendor(){
    //Fire select * from db table
    return vendorDB.findAll();
}

//Read single vendor by KEY - READ TABLE itab WITH KEY
public Optional<Vendor> readVendorById(String vendorId){
    return vendorDB.findById(vendorId);
}

//Add new record to vendors - APPEND wa to itab
public Vendor addVendor(Vendor newVendor){
    return vendorDB.save(newVendor);
} 

public Vendor updateVendorById(String vendorId, Vendor vendorData){
    Optional<Vendor> vendorFound = vendorDB.findById(vendorId);
    return vendorDB.save(vendorData);
}

public String deleteVendor(String vendorId){
    vendorDB.deleteById(vendorId);
    return "Object was deleted";
}
}
