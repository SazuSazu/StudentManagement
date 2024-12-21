package com.example.management.controller;

import com.example.management.api.ApiResponse;
import com.example.management.api.ApiVersion;
import com.example.management.api.ResponseUtils;
import com.example.management.api.model.ApiVersions;
import com.example.management.model.Course;
import com.example.management.model.Student;
import com.example.management.service.student.StudentService;
import com.example.management.v1.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/getStudent")
    public ResponseEntity<ApiResponse> getStudent (
    ){
        try{
            List<Student> students = studentService.retrieveStudent();
            if(students.isEmpty()){
                return ResponseUtils.notFoundError(ApiVersions.V1, ErrorCodes.ERROR_STU_02);
            }
            return ResponseUtils.ok(ApiVersions.V1, students);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_03);
        }
    }

    @GetMapping(path = "/search")
    public ResponseEntity<ApiResponse> getStudentParamenter (
            @RequestParam(required = false,defaultValue = "") String id,
            @RequestParam(required = false,defaultValue = "") String name,
            @RequestParam(required = false,defaultValue = "") Boolean pass
    ){
        try{
            List<Student> students = studentService.findStudentsByParams(id,name,pass);
            if(students.isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_02);
            }
            return ResponseUtils.ok(ApiVersions.V1, students);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_01);
        }
    }

    @GetMapping(path = "/studentPass")
    public ResponseEntity<ApiResponse> getCourse (@RequestBody Student student){
        try{
            Boolean isPass = studentService.isPass(student);
            return ResponseUtils.ok(ApiVersions.V1, isPass);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STATUS);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse> addStudent (@RequestBody Student student){
        try {
            boolean studentAdded = studentService.addStudent(student);
            if (studentAdded) {
                return ResponseUtils.ok(ApiVersions.V1, "Succefully Add Student");
            } else {
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_02);
            }
        }catch(Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_01);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ApiResponse> updateStudent (@RequestBody Student student){
        try {
            Student updatedStudent = studentService.updateStudent(student);
            if (updatedStudent != null) {
                return ResponseUtils.ok(ApiVersions.V1, student);
            } else {
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_02);
            }
        } catch (Exception e) {
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_01);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ApiResponse> deleteStudent (@PathVariable String id){
        boolean isDeleted = studentService.deleteStudent(id.toLowerCase());
        if (isDeleted) {
            return ResponseUtils.ok(ApiVersions.V1, "Successfully Deleted");
        }
        return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_STU_02);
    }

}
