package com.example.management.dao;

import com.example.management.dao.course.CourseDAO;
import com.example.management.dao.course.CourseDAOImpl;
import com.example.management.dao.lecturer.LecturerDAO;
import com.example.management.dao.lecturer.LecturerDAOImpl;
import com.example.management.dao.student.StudentDAO;
import com.example.management.dao.student.StudentDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfiguration {

    @Bean
    public StudentDAO studentDAO (){
        return new StudentDAOImpl();
    }

    @Bean
    public CourseDAO courseDAO () {
        return new CourseDAOImpl();
    }

    @Bean
    public LecturerDAO lecturerDAO() {
        return new LecturerDAOImpl();
    }
}
