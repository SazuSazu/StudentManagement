package com.example.management.dao.student;

import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Student> retrieveStudent() {
        String sql = "SELECT * FROM student";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getString("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setPass(rs.getBoolean("pass"));
            return student;
        });
    }
}
