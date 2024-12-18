package com.example.management.v1;

import com.example.management.api.model.ApiError;
import com.example.management.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

public enum ErrorCourseCode implements ApiError {

    ERROR_COURSE_01("Incorrect Course code or Course code cant be null" ),
    ERROR_COURSE_02("Course code does not exists in database" );


    final String message;

    ErrorCourseCode(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
