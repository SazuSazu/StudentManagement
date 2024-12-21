package com.example.management.v1;

import com.example.management.api.model.ApiError;

public enum ErrorCodes implements ApiError {

    ERROR_STU_01("Student Record is Empty"),
    ERROR_STU_02("Can't Retrieve Student Data"),
    ERROR_STU_03("Can't Add Student"),
    ERROR_CRS_01("Course Record is Empty"),
    ERROR_CRS_02("Can't Retrieve Course Data"),
    ERROR_CRS_03("Can't Add Course"),
    ERROR_LEA_01("Lecturer Record is Empty"),
    ERROR_LEA_02("Can't Retrieve Lecturer Data"),
    ERROR_LEA_03("Can't Add Lecturer"),
    ERROR_STATUS("Failed to retrieve status");

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
