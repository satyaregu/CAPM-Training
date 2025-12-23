package com.bms.dbboot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dbboot.entities.Vendor;
import com.bms.dbboot.service.VendorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class VendorController {

        @Autowired
        private VendorService myVendorSrv;

        @RequestMapping("/vendors")
        public List<Vendor> getAll() {
            return myVendorSrv.getAllVendor();
        }

        @PostMapping("/vendors")
        public Vendor addVendor(@RequestBody Vendor myVendor) {
            System.out.println(myVendor);
            return myVendorSrv.addVendor(myVendor);
        }
        
        
}
