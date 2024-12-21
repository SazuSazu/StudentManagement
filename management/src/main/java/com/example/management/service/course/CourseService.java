package com.example.management.service.course;

import com.example.management.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> retrieveCourse();
    Course createCourse(Course course);
    List<Course> deleteCourse(String course);
}
