package com.example.management.service;

import com.example.management.service.course.CourseService;
import com.example.management.service.course.CourseServiceImpl;
import com.example.management.service.student.StudentService;
import com.example.management.service.student.StudentServiceImpl;
import com.example.management.service.teacher.LecturerService;
import com.example.management.service.teacher.LecturerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public CourseService courseService() {
        return new CourseServiceImpl();
    }

    @Bean
    public LecturerService lecturerService() { return new LecturerServiceImpl();
    }

}
