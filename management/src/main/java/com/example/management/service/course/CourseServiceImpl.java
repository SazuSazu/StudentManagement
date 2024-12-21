package com.example.management.service.course;

import com.example.management.dao.course.CourseDAO;
import com.example.management.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseDAO;

    public List<Course> retrieveCourse() {
        return courseDAO.retrieveCourse();
    }

    public Course createCourse(Course course) {
        return courseDAO.createCourse(course);
    }

    public List<Course> deleteCourse(String code) {

        return courseDAO.deleteCourse(code);
    }
}
