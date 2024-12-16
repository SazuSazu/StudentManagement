package com.example.management.service.student;

import com.example.management.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> retrieveStudent();

    List<Student> findStudentsByParams(String id, String name, Boolean pass);

    boolean addStudent(Student student);

    Student updateStudent(Student student);

    boolean deleteStudent(String id);
}
