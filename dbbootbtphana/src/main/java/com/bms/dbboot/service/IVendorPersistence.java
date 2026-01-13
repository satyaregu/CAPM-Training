package com.bms.dbboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bms.dbboot.entities.Vendor;
import java.util.List;


public interface IVendorPersistence extends JpaRepository<Vendor, String> {

    //Adding custom functions apart from JPA Repository

    //Function to Search Vendor by Company Name
    List<Vendor> findByComapnyName(String comapnyName);

    //Function to Search Vendor by Email ID
    @Query(nativeQuery = true, value = "select * from public.VENDOR where EMAIL like %?1%" )
    List<Vendor> findByEmailId(String emailId);

}
