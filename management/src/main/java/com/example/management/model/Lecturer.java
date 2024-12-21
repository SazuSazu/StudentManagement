package com.example.management.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lecturer {
    private String id;
    private String name;
    private String course;
}
