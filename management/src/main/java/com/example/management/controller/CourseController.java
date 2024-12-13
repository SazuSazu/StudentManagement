package com.example.management.controller;

import com.example.management.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/course/v1")
public class CourseController {

    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse> addCourse (
    ){
        return null;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ApiResponse> updateCourse (
    ){
        return null;
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<ApiResponse> deleteCourse (
    ){
        return null;
    }
}
