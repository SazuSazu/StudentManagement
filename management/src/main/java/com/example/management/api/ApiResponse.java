package com.example.management.api;


import com.example.management.api.model.ApiError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    @AllArgsConstructor
    @Getter
    public static  class Error {
        private String code;
        private String message;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<InternalError> errors = new ArrayList<>();

        public Error(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }
    private String ver;
    private String requestId;
    private Object data;
    private Error error;

    public static ApiResponse success(ApiVersion apiVersion, Object data){
        ApiResponse response = new ApiResponse();
        response.ver = apiVersion.getVer();
        response.data = data;
        return response;
    }

    public static ApiResponse error(ApiVersion apiVersion, ApiError error, Object... errorArgs){
        ApiResponse response = new ApiResponse();
        response.ver = apiVersion.getVer();
        response.error = new Error(error.getCode(), String.format(error.getMessage(), errorArgs));
        return response;
    }

    public static ApiResponse error(ApiVersion apiVersion, Error error){
        ApiResponse response = new ApiResponse();
        response.ver = apiVersion.getVer();
        response.error = error;
        return response;
    }
}
