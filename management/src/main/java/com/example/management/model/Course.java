package com.example.management.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    private String code;
    private String name;
    private int minMark;
}
