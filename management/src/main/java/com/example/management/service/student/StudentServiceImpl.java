package com.example.management.service.student;

import com.example.management.dao.course.CourseDAO;
import com.example.management.dao.student.StudentDAO;
import com.example.management.model.Course;
import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseDAO courseDAO;

    public List<Student> retrieveStudent(){
        return studentDAO.retrieveStudent();
    }

    public List<Student> findStudentsByParams(String id, String name, Boolean pass) {
        return studentDAO.findStudentsByParams(id, name, pass);
    }

    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    public boolean isPass(Student student){
        double studentMark = student.getMark() != null ? student.getMark() : 0;
        Double courseMark = courseDAO.retrieveMark(student.getCourse());
        return studentMark > courseMark;
    }

    public boolean deleteStudent(String id) {
        return studentDAO.deleteStudentById(id);
    }
}
