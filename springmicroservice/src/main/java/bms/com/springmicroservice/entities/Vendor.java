package bms.com.springmicroservice.entities;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Vendor {
private String code;
private String comapnyName;
private String contactPerson;
private String firstName;
private String lastName;
private String website;
private String email;
private Integer status;
private Date regDate;

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

}
