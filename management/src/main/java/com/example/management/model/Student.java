package com.example.management.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    private String id;
    private String name;
    private int age;
    private String course;
    private Double mark;
    private Boolean pass;
}
