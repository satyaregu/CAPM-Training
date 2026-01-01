package com.bms.dbboot.service;

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

//update vendor by id
public Vendor updateVendorById(String vendorId, Vendor vendorData){
    Optional<Vendor> vendorFound = vendorDB.findById(vendorId);
    return vendorDB.save(vendorData);
}

//delete vendor by id
public String deleteVendor(String vendorId){
    vendorDB.deleteById(vendorId);
    return "Object was deleted";
}

//Search Vendor by Company Name
public List<Vendor> getVendorByCompanyName(String companyName){
    return vendorDB.findByComapnyName(companyName);
}

//Search Vendor by Email ID
public List<Vendor> getVendorByEmailId(String emailId){
    return vendorDB.findByEmailId(emailId);
}
}
