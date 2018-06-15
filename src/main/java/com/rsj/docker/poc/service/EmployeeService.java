package com.rsj.docker.poc.service;

import com.rsj.docker.poc.model.Address;
import com.rsj.docker.poc.model.ContactCard;
import com.rsj.docker.poc.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployeeDetails(){

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(getEmployee());
        return employeeList;
    }

    @Value("${employee.type}")
    private String employeeType;

    private  Employee getEmployee(){

        Employee employee = new Employee();
        employee.setEmployeeId("0000001");
        employee.setBusinessLine("Banking");
        employee.setEmployeeName("PNC Bank");
        employee.setAddress(getAddress());
        employee.setContactCard(getContactCard());
        employee.setEmployeeType("employeeType");

     return employee;
    }

    private Address getAddress(){

        Address address = new Address();
        address.setAddressLine1("100");
        address.setAddressLine2("Eliabeth Drive");
        address.setCity("Pittsburgh");
        address.setState("PA");
        address.setZip("15220");
        address.setCountry("USA");

        return address;
    }

    private ContactCard getContactCard(){

        ContactCard contactCard = new ContactCard();
        contactCard.setEmail("abc@pnc.com");
        contactCard.setFax("001123456789");
        contactCard.setPhone("+15512080223");

        return contactCard;
    }
}
