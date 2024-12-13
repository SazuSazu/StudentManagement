package com.example.management.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String id;
    private String name;
    private int age;
    private List<Course> courseList;
    private Boolean pass;
}
