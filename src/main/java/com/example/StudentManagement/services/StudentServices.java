package com.example.StudentManagement.services;

import java.util.List;

import com.example.StudentManagement.models.Student;

public interface StudentServices {

    // Create Student
    public Student createStudent(Student student);

    // Get Student By Id
    public Student getStudentById(Long id);

    // Get Student By Email
    public Student getStudentByEmail(String email);

    // Get All Student
    public List<Student> getAllStudents();

    // Update Student By Id
    public Student updateStudentById(Long id, Student updateStudent);

    // Delete Student By id
    public void deleteStudentById(Long id);

    // Delete all Student
    public void deleteAllStudent();

}
