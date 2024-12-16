package com.example.management.model;

import lombok.Data;

@Data
public class Course {
    private String code;
    private String name;
    private float mark;
    private int minMark;
}
