package com.example.management.controller;

import com.example.management.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/teacher/v1")
public class TeacherController {

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
