package com.example.management.service.student;

import com.example.management.dao.student.StudentDAO;
import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> retrieveStudent(){
        return studentDAO.retrieveStudent();
    }

    @Override
    public List<Student> findStudentsByParams(String id, String name, Boolean pass) {
        return studentDAO.findStudentsByParams(id, name, pass);
    }

    @Override 
    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override 
    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    public boolean deleteStudent(String id) {
        return studentDAO.deleteStudentById(id);
    }

}
