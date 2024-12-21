package com.example.management.dao.course;

import com.example.management.model.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> retrieveCourse();
    Double retrieveMark(String code);
    Course createCourse(Course course);
    List<Course> deleteCourse(String code);
}
