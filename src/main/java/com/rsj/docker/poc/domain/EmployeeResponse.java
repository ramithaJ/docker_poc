package com.rsj.docker.poc.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeResponse extends ResponseEntity {

    public EmployeeResponse(Object body, HttpStatus status) {
        super(body, status);
    }
}
