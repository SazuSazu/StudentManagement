package com.example.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ManagementApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] sqlStatements = {
				"CREATE TABLE IF NOT EXISTS student ("
						+ "id VARCHAR(255) PRIMARY KEY, "
						+ "name VARCHAR(255) NOT NULL, "
						+ "age INT NOT NULL, "
						+ "pass BOOLEAN NOT NULL);",
				"CREATE TABLE IF NOT EXISTS course ("
						+ "code VARCHAR(255) PRIMARY KEY, "
						+ "name VARCHAR(255) NOT NULL, "
						+ "minMark INT NOT NULL);",
				"CREATE TABLE IF NOT EXISTS lecturer ("
						+ "id VARCHAR(255) PRIMARY KEY, "
						+ "name VARCHAR(255) NOT NULL, "
						+ "course VARCHAR(255) NOT NULL);",

				"INSERT INTO student (id, name, age, pass) VALUES ('S001', 'Hisyam', 20, TRUE);",
				"INSERT INTO lecturer (id, name, course) VALUES ('L001', 'Sazwan', 'MATH');",
				"INSERT INTO course (code, name, minMark) VALUES ('MATH', 'Mathematics', 65);"
		};

		for (String sql : sqlStatements) {
			jdbcTemplate.execute(sql);
		}
		System.out.println("Table created and data inserted successfully!");
	}

}
