package com.rsj.docker.poc.model;

public class Employee {

    private String employeeName;
    private String employeeId;
    private String businessLine;
    private Address address;
    private ContactCard contactCard;

    public ContactCard getContactCard() {
        return contactCard;
    }

    public void setContactCard(ContactCard contactCard) {
        this.contactCard = contactCard;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
