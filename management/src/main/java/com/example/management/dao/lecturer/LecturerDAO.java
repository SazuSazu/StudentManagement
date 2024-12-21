package com.example.management.dao.lecturer;
import com.example.management.model.Lecturer;
import com.example.management.model.Student;

import java.util.List;

public interface LecturerDAO {

    boolean addLecturer(Lecturer lecturer);
    boolean deleteLecturerById(String id);
    List<Lecturer> retrieveLecturer();

}
