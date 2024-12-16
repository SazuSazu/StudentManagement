package com.example.management.v1;

import com.example.management.api.model.ApiError;

public enum ErrorCodes implements ApiError {

    ERROR_STU_01("Database Student Doesn't exist in Database"),
    ERROR_STU_02("No Student Record");


    final String message;

    ErrorCodes(String message){
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
