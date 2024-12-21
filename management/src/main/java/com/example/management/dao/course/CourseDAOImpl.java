package com.example.management.dao.course;

import com.example.management.model.Course;
import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAOImpl implements CourseDAO{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Course> retrieveCourse() {
        String sql = "SELECT * FROM Course";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course course = new Course();
            course.setCode(rs.getString("code"));
            course.setName(rs.getString("name"));
            course.setMinMark(rs.getInt("minMark"));
            return course;
        });
    }

    public Double retrieveMark(String id) {
        StringBuilder query = new StringBuilder("SELECT minMark FROM course WHERE 1=1 ");
        Map<String, Object> params = new HashMap<>();

        if (id != null && !id.isEmpty()) {
            query.append(" AND code = :code");
            params.put("code", id);
        }
        Double result = jdbcTemplate.queryForObject(query.toString(), params, Double.class);
        return result != null ? result : 0.0;
    }

    @Override
    public Course createCourse(Course course) {
        String sql = "INSERT INTO Course (code, name, minMark) VALUES (:code, :name, :minMark)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("code", course.getCode());
        params.addValue("name", course.getName());
        params.addValue("minMark", course.getMinMark());

        jdbcTemplate.update(sql, params);

        return course;
    }

    @Override
    public List<Course> deleteCourse(String code) {
        String sql = "DELETE FROM Course WHERE code = :code";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("code", code);

        jdbcTemplate.update(sql, params);

        return retrieveCourse();
    }
}
