package com.example.management.controller;

import com.example.management.api.ApiResponse;
import com.example.management.api.ResponseUtils;
import com.example.management.api.model.ApiVersions;
import com.example.management.model.Course;
import com.example.management.model.Lecturer;
import com.example.management.service.teacher.LecturerService;
import com.example.management.v1.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lecturer/v1")
public class LecturerController {

    @Autowired
    LecturerService lecturerService;

    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse> addLecturer(@RequestBody Lecturer lecturer){
        try {
            boolean studentAdded = lecturerService.addLecturer(lecturer);
            if (studentAdded) {
                return ResponseUtils.ok(ApiVersions.V1, "Successfully Add");
            } else {
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_LEA_02);
            }
        }catch(Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_LEA_03);
        }
    }

    @GetMapping(path = "/get")
    public ResponseEntity<ApiResponse> getLecturer (){
        try{
            List<Lecturer> lecturer = lecturerService.retrieveLecturer();
            if(lecturer.isEmpty()){
                return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_LEA_01);
            }
            return ResponseUtils.ok(ApiVersions.V1, lecturer);
        }catch (Exception e){
            return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_LEA_02);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ApiResponse> deleteLecturer (@PathVariable String id){
        boolean isDeleted = lecturerService.deleteLecturer(id.toLowerCase());
        if (isDeleted) {
            return ResponseUtils.ok(ApiVersions.V1, "Successfully Deleted");
        }
        return ResponseUtils.error(ApiVersions.V1, ErrorCodes.ERROR_LEA_02);
    }
}
