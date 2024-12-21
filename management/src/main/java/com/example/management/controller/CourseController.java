package com.example.management.controller;

import com.example.management.api.ApiResponse;
import com.example.management.api.ResponseUtils;
import com.example.management.api.model.ApiVersions;
import com.example.management.model.Course;
import com.example.management.model.Student;
import com.example.management.service.course.CourseService;
import com.example.management.v1.ErrorCodes;
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
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_CRS_01);
            }
            return ResponseUtils.ok(ApiVersions.V1, courses);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_CRS_02);
        }
    }


    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse> addCourse (@RequestBody Course course){
        try{
            Course createCourse = courseService.createCourse(course);
            if(createCourse != null){
                return ResponseUtils.ok(ApiVersions.V1, "Successfully Added");
            }
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_CRS_01);
        } catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_CRS_03);
        }
    }

    @DeleteMapping(path = "/delete/{code}")
    public ResponseEntity<ApiResponse> deleteCourse (@PathVariable String code){
        try{
            List<Course> deleteCourses = courseService.deleteCourse(code);
            if (code == null || code.trim().isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_CRS_01);
            }
            return ResponseUtils.ok(ApiVersions.V1, "Successfully Deleted");

        } catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_CRS_02);
        }
    }
}
