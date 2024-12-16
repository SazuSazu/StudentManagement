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
}
