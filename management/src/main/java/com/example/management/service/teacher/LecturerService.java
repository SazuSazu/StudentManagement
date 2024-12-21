package com.example.management.service.teacher;

import com.example.management.model.Lecturer;
import com.example.management.model.Student;

import java.util.List;

public interface LecturerService {

    boolean addLecturer(Lecturer lecturer);
    boolean deleteLecturer(String id);
    List<Lecturer> retrieveLecturer();

}
