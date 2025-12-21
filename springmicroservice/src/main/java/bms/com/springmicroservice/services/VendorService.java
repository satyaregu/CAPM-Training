package bms.com.springmicroservice.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bms.com.springmicroservice.entities.Vendor;

@Component
public class VendorService {
//this is like a internal table in Java
//this is a variable which can store multiple vendor objects
private HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();

@Autowired
private Vendor ven1;
@Autowired
private Vendor ven2;
@Autowired
private Vendor ven3;

private void fillVendors(){
    vendors.put("1", ven1);
    vendors.put("2", ven2);
    vendors.put("3", ven3);

}

public VendorService(){
    fillVendors();
}

//Read all vendors - Returns an internal table
public HashMap<String, Vendor> getAllVendor(){
    return vendors;
}

//Read single vendor by KEY - READ TABLE itab WITH KEY
public Vendor readVendorById(String vendorId){
    return vendors.get(vendorId);
}

//Add new record to vendors - APPEND wa to itab
public Vendor addVendor(Vendor newVendor){
    vendors.put("4", newVendor);
    return newVendor;
} 

public Vendor updateVendorById(String vendorId, Vendor vendorData){
    vendors.put(vendorId, vendorData);
    return vendorData;
}

public void deleteVendor(String vendorId){
    vendors.remove(vendorId);
}
}
