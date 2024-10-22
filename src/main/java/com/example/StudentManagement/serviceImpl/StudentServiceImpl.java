package com.example.StudentManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagement.exceptions.StudentNotFound;
import com.example.StudentManagement.models.Student;
import com.example.StudentManagement.repositories.StudentRepo;
import com.example.StudentManagement.services.StudentServices;

@Service
public class StudentServiceImpl implements StudentServices {

    @Autowired
    private StudentRepo studentRepo;

    // Save Employee
    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    // Get Employee By Id
    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFound("Student not found"));
    }

    // Get Student By Email
    @Override
    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email)
                .orElseThrow(() -> new StudentNotFound("Student not found with given email : " + email));

    }

    // Get All Employees
    @Override
    public List<Student> getAllStudents() {
        List<Student> stdList = studentRepo.findAll();

        if (stdList.isEmpty()) {
            throw new StudentNotFound("Students Not Found");
        }
        return stdList;
    }

    // Update Employee by Id
    @Override
    public Student updateStudentById(Long id, Student student) {
        Student updateStudent = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFound("Student not found with given id..."));

        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setCourse(student.getCourse());
        updateStudent.setAge(student.getAge());

        studentRepo.save(updateStudent);
        return updateStudent;
    }

    // Delete Employee by id
    @Override
    public void deleteStudentById(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFound("Student not found with provided id"));
        studentRepo.deleteById(id);
    }

    // Delete All Employees

    @Override
    public void deleteAllStudent() {
        List<Student> empList = studentRepo.findAll();
        if (empList.isEmpty()) {
            throw new StudentNotFound("Students Not found");
        }
        studentRepo.deleteAll();
    }

}
