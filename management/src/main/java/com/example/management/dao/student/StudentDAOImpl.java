package com.example.management.dao.student;

import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Student> retrieveStudent() {
        String sql = "SELECT * FROM Student";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getString(1));
            student.setName(rs.getString(2));
            student.setAge(rs.getInt(3));
            student.setPass(rs.getBoolean(4));
            return student;
        });
    }
}
