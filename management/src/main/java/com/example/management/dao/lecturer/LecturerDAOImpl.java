package com.example.management.dao.lecturer;

import com.example.management.model.Lecturer;
import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturerDAOImpl implements LecturerDAO{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public boolean addLecturer(Lecturer lecturer) {
        String sql = "INSERT INTO Lecturer (id, name, course) VALUES (:id,:name,:course)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", lecturer.getId());
        params.put("name", lecturer.getName());
        params.put("course", lecturer.getCourse());


        int rowsAffected = jdbcTemplate.update(sql, params);
        return rowsAffected > 0;
    }

    public List<Lecturer> retrieveLecturer() {
        String sql = "SELECT * FROM lecturer";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Lecturer lecturer = new Lecturer();
            lecturer.setId(rs.getString("id"));
            lecturer.setName(rs.getString("name"));
            lecturer.setCourse(rs.getString("course"));
            return lecturer;
        });
    }

    public boolean deleteLecturerById(String id) {
        String sql = "DELETE FROM lecturer WHERE LOWER(id) = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        int rowsAffected = jdbcTemplate.update(sql, params);
        return rowsAffected > 0;
    }
}
