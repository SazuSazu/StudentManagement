package com.example.management.controller;

import com.example.management.api.ApiResponse;
import com.example.management.api.ResponseUtils;
import com.example.management.api.model.ApiVersions;
import com.example.management.model.Course;
import com.example.management.service.course.CourseService;
import com.example.management.v1.ErrorCourse;
import com.example.management.v1.ErrorCourseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course/v1")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(path = "/get")
    public ResponseEntity<ApiResponse> getCourse (){
        try{
            List<Course> courses = courseService.retrieveCourse();
            if(courses.isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCourse.ERROR_COURSE_02);
            }
            return ResponseUtils.ok(ApiVersions.V1, courses);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCourse.ERROR_COURSE_01);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse> addCourse (@RequestBody Course course){
        try{
            Course createCourse = courseService.createCourse(course);
            if(createCourse != null){
                return ResponseUtils.ok(ApiVersions.V1, createCourse);
            }
            return ResponseUtils.error(ApiVersions.V1, ErrorCourse.ERROR_COURSE_02);
        } catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCourse.ERROR_COURSE_02);
        }
    }

    @PutMapping(path = "/update/{code}")
    public ResponseEntity<ApiResponse> updateCourse (@PathVariable String code,
                                                     @RequestBody Course course) {
        try {
            // to perform the update
            List<Course> updatedCourses = courseService.updateCourse(code, course);

            if(code == null || code.trim().isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCourseCode.ERROR_COURSE_02);
            }

            // Return the updated list of courses
            return ResponseUtils.ok(ApiVersions.V1, updatedCourses);
        } catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCourseCode.ERROR_COURSE_01);
        }
    }

    @DeleteMapping(path = "/delete/{code}")
    public ResponseEntity<ApiResponse> deleteCourse (@PathVariable String code){
        try{
            List<Course> deleteCourses = courseService.deleteCourse(code);
            if (code == null || code.trim().isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCourseCode.ERROR_COURSE_02);
            }

            return ResponseUtils.ok(ApiVersions.V1, deleteCourses);

        } catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCourseCode.ERROR_COURSE_01);
        }
    }
}

