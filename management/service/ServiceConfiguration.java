package com.example.management.service;

import com.example.management.service.student.StudentService;
import com.example.management.service.student.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }
}
