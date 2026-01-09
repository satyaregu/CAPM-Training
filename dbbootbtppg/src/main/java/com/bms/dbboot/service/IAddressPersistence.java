package com.bms.dbboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.dbboot.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, String>{


}
