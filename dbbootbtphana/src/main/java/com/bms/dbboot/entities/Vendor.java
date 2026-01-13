package com.bms.dbboot.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Scope("prototype")
@Entity
@Table(name = "VENDOR")
public class Vendor {
    
@Id
@Column(nullable = false, name = "ID")
@GeneratedValue(generator = "uuid2")   
private String code;

@Column(nullable = false, name = "COMPANY_NAME")
private String comapnyName;

@Column(nullable = false, name = "CONTACT")
private String contactPerson;

@Column(nullable = false, name = "FIRST_NAME")
private String firstName;

@Column(nullable = false, name = "LAST_NAME")
private String lastName;

@Column(nullable = false, name = "WEBSITE")
private String website;

@Column(nullable = false, name = "EMAIL")
private String email;

@Column(nullable = false, name = "STATUS")
private Integer status;

@Column(nullable = false, name = "REG_DATE")
private Date regDate;

//Create association with Address table
@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "vendor", referencedColumnName = "ID")
private List<Address> addresses = new ArrayList<Address>();



//Default constructor without arguments
public Vendor() {
    this.code = "VEN";
    this.comapnyName = "BMS";
    this.contactPerson = "SATYA";
    this.firstName = "JYOTHI";
    this.lastName = "REGU";
    this.status = 0;
    this.website = comapnyName + ".com";
    this.email = firstName + "." + lastName + "@" + comapnyName + ".com" ;
    this.regDate = new Date();
}

public Vendor(String code, String comapnyName, String contactPerson, String firstName, String lastName) {
    this.code = code;
    this.comapnyName = comapnyName;
    this.contactPerson = contactPerson;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = 0;
    this.website = comapnyName + ".com";
    this.email = firstName + "." + lastName + "@" + comapnyName + ".com" ;
    this.regDate = new Date();
}

public String getCode() {
    return code;
}
public void setCode(String code) {
    this.code = code;
}
public String getComapnyName() {
    return comapnyName;
}
public void setComapnyName(String comapnyName) {
    this.comapnyName = comapnyName;
}
public String getContactPerson() {
    return contactPerson;
}
public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public String getWebsite() {
    return website;
}
public void setWebsite(String website) {
    this.website = website;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public Integer getStatus() {
    return status;
}
public void setStatus(Integer status) {
    this.status = status;
}
public Date getRegDate() {
    return regDate;
}
public void setRegDate(Date regDate) {
    this.regDate = regDate;
}

public List<Address> getAddresses() {
    return addresses;
}

public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
}

}
