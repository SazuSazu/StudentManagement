package com.example.management.api;


import com.example.management.api.model.ApiError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

    @AllArgsConstructor
    @Getter
    public static  class Error {
        private String code;
        private String msg;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<InternalError> errors = new ArrayList<>();

        public Error(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    private String ver;
    private String requestId;
    private Object data;
    private Error error;

    public static ApiResponse success(ApiVersion apiVersion, Object data){
        ApiResponse response = new ApiResponse();
        response.ver = apiVersion.getVer();
        response.requestId = RequestID.get();
        response.data = data;
        return response;
    }

    public static ApiResponse error(ApiVersion apiVersion, ApiError error, Object... errorArgs){
        ApiResponse response = new ApiResponse();
        response.ver = apiVersion.getVer();
        response.requestId = RequestID.get();
        response.error = new Error(error.getCode(), String.format(error.getMessage(), errorArgs));
        return response;
    }

    public static ApiResponse error(ApiVersion apiVersion, Error error){
        ApiResponse response = new ApiResponse();
        response.ver = apiVersion.getVer();
        response.requestId = RequestID.get();
        response.error = error;
        return response;
    }
}
