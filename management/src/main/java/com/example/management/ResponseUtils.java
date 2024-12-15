package com.example.management.api;

import com.example.management.api.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    public  static ResponseEntity<ApiResponse> ok(ApiVersion apiVersion, Object data){
        return ResponseEntity.ok(ApiResponse.success(apiVersion, data));
    }

    public  static ResponseEntity<ApiResponse> error (ApiVersion apiVersion, ApiError error, Object... errorArgs){
        return new ResponseEntity<>(ApiResponse.error(apiVersion, error, errorArgs), HttpStatus.NOT_FOUND);
    }
}
