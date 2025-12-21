package bms.com.springmicroservice.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bms.com.springmicroservice.entities.Vendor;
import bms.com.springmicroservice.services.VendorService;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VendorController {

        @Autowired
        private VendorService myVendorSrv;

        @RequestMapping("/vendors")
        public HashMap<String, Vendor> getAll() {
            return myVendorSrv.getAllVendor();
        }
        
}
