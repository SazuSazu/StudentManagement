package com.example.management.dao;

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
}
