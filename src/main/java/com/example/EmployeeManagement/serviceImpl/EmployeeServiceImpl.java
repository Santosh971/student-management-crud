package com.example.EmployeeManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagement.exceptions.EmployeeNotFound;
import com.example.EmployeeManagement.models.Employee;
import com.example.EmployeeManagement.repositories.EmployeeRepo;
import com.example.EmployeeManagement.services.EmployeeServices;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepo employeeRepo;

    // Save Employee
    @Override
    public Employee createEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    // Get Employee By Id
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee not found"));
    }

    // Get All Employees
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empList = employeeRepo.findAll();

        if (empList.isEmpty()) {
            throw new EmployeeNotFound("Employees Not Found");
        }
        return empList;
    }

    // Update Employee by Id
    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee updateEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found with given id..."));

        updateEmployee.setName(employee.getName());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setDepartment(employee.getDepartment());
        updateEmployee.setSalary(employee.getSalary());

        employeeRepo.save(updateEmployee);
        return updateEmployee;
    }

    // Delete Employee by id
    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found with provided id"));
        employeeRepo.deleteById(id);
    }

    // Delete All Employees

    @Override
    public void deleteAllEmployee() {
        List<Employee> empList = employeeRepo.findAll();
        if (empList.isEmpty()) {
            throw new EmployeeNotFound("Employees Not found");
        }
        employeeRepo.deleteAll();
    }

}
