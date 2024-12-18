package com.example.management.v1;

import com.example.management.api.model.ApiError;

public enum ErrorCourse implements ApiError {

    ERROR_COURSE_01("Database Course Doesn't exist in Database" ),
    ERROR_COURSE_02("Error" );



    final String message;

    ErrorCourse(String message) {
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

