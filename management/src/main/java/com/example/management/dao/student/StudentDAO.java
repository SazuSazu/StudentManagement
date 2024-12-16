package com.example.management.dao.student;

import com.example.management.model.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> retrieveStudent();
    
    List<Student> findStudentsByParams(String id, String name, Boolean pass);

    boolean addStudent(Student student);

    Student updateStudent(Student student);

    boolean deleteStudentById(String id);
}
