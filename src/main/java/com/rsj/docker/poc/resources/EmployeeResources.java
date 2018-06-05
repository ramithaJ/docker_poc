package com.rsj.docker.poc.resources;

import com.rsj.docker.poc.domain.EmployeeResponse;
import com.rsj.docker.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class EmployeeResources {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(path = "/employee" ,method =RequestMethod.GET)
    private EmployeeResponse getEmployeeList(){

        return  new EmployeeResponse(employeeService.getEmployeeDetails(),HttpStatus.OK);
    }
}
