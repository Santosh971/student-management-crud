package com.example.StudentManagement.controllers;

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

import com.example.StudentManagement.models.Student;
import com.example.StudentManagement.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    // Create and save Student
    @PostMapping("/create")
    public Student save(@RequestBody Student student) {
        return studentServiceImpl.createStudent(student);
    }

    // Get Student by id
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentServiceImpl.getStudentById(id);
    }

    // Get Student by Email
    @GetMapping("/getStudentByEmail/{email}")
    public Student getStudent(@PathVariable String email) {
        return studentServiceImpl.getStudentByEmail(email);
    }

    // Get all Students
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentServiceImpl.getAllStudents();
    }

    // Update Student by Id
    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student, @PathVariable Long id) {
        return studentServiceImpl.updateStudentById(id, student);
    }

    // Delete Student by id
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentServiceImpl.deleteStudentById(id);
        return "Student remove Successfully with Student id : " + id;
    }

    // Delete All Students
    @DeleteMapping("/deleteAll")
    public String deleteAllEmployee() {
        studentServiceImpl.deleteAllStudent();
        return "All Students remove Successfully ";
    }
}
