package com.bms.dbboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dbboot.entities.Vendor;
import com.bms.dbboot.service.VendorService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VendorController {

        @Autowired
        private VendorService myVendorSrv;

        //get all vendor records
        @RequestMapping("/vendors")
        public List<Vendor> getAll() {
            return myVendorSrv.getAllVendor();
        }

        //Create a new vendor
        @PostMapping("/vendors")
        public Vendor addVendor(@RequestBody Vendor myVendor) {
            System.out.println(myVendor);
            return myVendorSrv.addVendor(myVendor);
        }

        //Read Vendor by id
        @RequestMapping("/vendors/{vendorCode}")
        public Optional<Vendor> readVendor(@PathVariable String code) {
            return myVendorSrv.readVendorById(code);
        }
        
        //update vendor by id
        @RequestMapping(method=RequestMethod.PUT, value = "/vendor/{vendorId}")
        public Vendor updatVendor(@PathVariable("vendorId") String vendorCode,
                                  @RequestBody Vendor vendor) {
            return myVendorSrv.updateVendorById(vendorCode, vendor);
        }
        
        //delete vendor by id
        @RequestMapping(method=RequestMethod.DELETE, value = "/vendor/{vendorId}")
        public String deleteVendor(@PathVariable String vendorId) {
            return myVendorSrv.deleteVendor(vendorId);
        }

        //Search vendor by company name
        @RequestMapping("/vendor/search")
        public List<Vendor> searchByCompanyName(@RequestParam String companyName) {
            return myVendorSrv.getVendorByCompanyName(companyName);
        }
        
        //Search vendor by email id
        @RequestMapping("/vendor/lookup/{emailId}")
        public List<Vendor> searchByEmailId(@PathVariable("emailId") String emailId) {
            return myVendorSrv.getVendorByEmailId(emailId);
        }
        
}
