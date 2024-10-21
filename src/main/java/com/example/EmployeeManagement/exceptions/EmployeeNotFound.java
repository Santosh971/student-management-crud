package com.example.EmployeeManagement.exceptions;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String msg) {
        super(msg);
    }

}
