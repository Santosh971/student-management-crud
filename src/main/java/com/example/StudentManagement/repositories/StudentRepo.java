package com.example.StudentManagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagement.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    // Student Find by Email
    public Optional<Student> findByEmail(String email);
}
