package com.example.management.model;

import lombok.Data;

@Data
public class Course {
    private String code;
    private String name;
    private float mark;
    private int minMark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public int getMinMark() {
        return minMark;
    }

    public void setMinMark(int minMark) {
        this.minMark = minMark;
    }
}

