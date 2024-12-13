package com.example.management.controller;

import com.example.management.api.ApiResponse;
import com.example.management.api.ApiVersion;
import com.example.management.api.ResponseUtils;
import com.example.management.api.model.ApiVersions;
import com.example.management.model.Student;
import com.example.management.service.student.StudentService;
import com.example.management.v1.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/get")
    public ResponseEntity<ApiResponse> getStudent (
    ){
        try{
            List<Student> students = studentService.retrieveStudent();
            if(students.isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_02);
            }
            return ResponseUtils.ok(ApiVersions.V1, students);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_01);
        }
    }

    @GetMapping(path = "/search")
    public ResponseEntity<ApiResponse> getStudentParamenter (
            @RequestParam(required = false, defaultValue = "") String id,
            @RequestParam(required = false, defaultValue = "") Boolean course,
            @RequestParam(required = false, defaultValue = "") Boolean pass
    ){
        return null;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse> addStudent (
    ){
       return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ApiResponse> updateStudent (
    ){
        return null;
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<ApiResponse> deleteStudent (
    ){
        return null;
    }
}
