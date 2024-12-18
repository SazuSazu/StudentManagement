package com.example.management.service.course;

import com.example.management.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> retrieveCourse(); //retrieve all course
    Course createCourse(Course course); //create new course
    List<Course>  updateCourse(String code, Course course); //update the course
    List<Course> deleteCourse(String course); //delete the course by code
}
