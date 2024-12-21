package com.example.management.dao.student;

import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Student> findStudentsByParams(String id, String name, Boolean pass) {
        StringBuilder query = new StringBuilder("SELECT * FROM Student  WHERE 1=1 ");
        Map<String, Object> params = new HashMap<>();

        if (!id.equals("")) {
            query.append(" AND LOWER(id) = :id");
            params.put("id", id.toLowerCase());
        }
        if (!name.equals("")) {
            query.append(" AND LOWER(name) = :name");
            params.put("name", name.toLowerCase());
        }
        if (pass != null) {
            query.append(" AND pass = :pass");
            params.put("pass", pass);
        }

        List<Student> students= jdbcTemplate.query(query.toString(),params,(rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getString("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setPass(rs.getBoolean("pass"));
            return student;
        });

        if (students.isEmpty()) {
            return null;
        }

        return students;
    }

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO Student (id,name, age,pass) VALUES (:id,:name, :age,:pass)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", student.getId());
        params.put("name", student.getName());
        params.put("age", student.getAge());
        params.put("pass", student.getPass());


        int rowsAffected = jdbcTemplate.update(sql, params);
        return rowsAffected > 0;
    }


    public Student updateStudent(Student student) {
        // Check if the student exists first
        String selectSql = "SELECT * FROM student WHERE LOWER(id) = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", student.getId().toLowerCase());

        List<Student> students = jdbcTemplate.query(selectSql, params, new BeanPropertyRowMapper<>(Student.class));

        if (students.isEmpty()) {
            return null;
        }

        String updateSql = "UPDATE student SET name = :name, age = :age, pass = :pass WHERE LOWER(id) = :id";
        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("name", student.getName());
        updateParams.put("age", student.getAge());
        updateParams.put("pass", student.getPass());
        updateParams.put("id", student.getId().toLowerCase());

        int rowsAffected = jdbcTemplate.update(updateSql, updateParams);

        if (rowsAffected > 0) {
            return student;
        }

        return null;
    }

    public boolean deleteStudentById(String id) {
        String sql = "DELETE FROM student WHERE LOWER(id) = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        int rowsAffected = jdbcTemplate.update(sql, params);
        return rowsAffected > 0;
    }
}
