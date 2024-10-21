package com.example.EmployeeManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagement.models.Employee;
import com.example.EmployeeManagement.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    // Create and save employee
    @PostMapping("/create")
    public Employee save(@RequestBody Employee employee) {
        return employeeServiceImpl.createEmployee(employee);
    }

    // Get Employee by id
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeServiceImpl.getEmployeeById(id);
    }

    // Get all Employees
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployee();
    }

    // Update Employee by Id
    @PutMapping("/update/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeServiceImpl.updateEmployeeById(id, employee);
    }

    // Delete Employee by id
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeServiceImpl.deleteEmployeeById(id);
        return "Employee remove Successfully with Employee id : " + id;
    }

    // Delete All Employees
    @DeleteMapping("/deleteAll")
    public String deleteAllEmployee() {
        employeeServiceImpl.deleteAllEmployee();
        return "All Employees remove Successfully ";
    }
}
