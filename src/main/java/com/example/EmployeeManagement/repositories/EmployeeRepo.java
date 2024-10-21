package com.example.EmployeeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
