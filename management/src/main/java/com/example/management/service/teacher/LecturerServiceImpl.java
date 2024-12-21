package com.example.management.service.teacher;

import com.example.management.dao.lecturer.LecturerDAO;
import com.example.management.model.Lecturer;
import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerDAO lecturerDAO;

    public boolean addLecturer(Lecturer lecturer) {
        return lecturerDAO.addLecturer(lecturer);
    }

    public boolean deleteLecturer(String id) {
        return lecturerDAO.deleteLecturerById(id);
    }

    public List<Lecturer> retrieveLecturer(){
        return lecturerDAO.retrieveLecturer();
    }
}
