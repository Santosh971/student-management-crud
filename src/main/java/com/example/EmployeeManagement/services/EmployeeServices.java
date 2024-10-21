package com.example.EmployeeManagement.services;

import java.util.List;

import com.example.EmployeeManagement.models.Employee;

public interface EmployeeServices {

    // Create Employee
    public Employee createEmployee(Employee emp);

    // Get Employee By Id
    public Employee getEmployeeById(Long id);

    // Get All Employee
    public List<Employee> getAllEmployee();

    // Update Employee By Id
    public Employee updateEmployeeById(Long id, Employee updateEmployee);

    // Delete Employee By id
    public void deleteEmployeeById(Long id);

    // Delete all Employee
    public void deleteAllEmployee();

}
