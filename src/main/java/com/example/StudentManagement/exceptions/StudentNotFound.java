package com.example.StudentManagement.exceptions;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(String msg) {
        super(msg);
    }

}
