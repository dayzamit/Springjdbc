package com.spring.jdbc.dao;

import com.spring.jdbc.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      student.setStudentId(rs.getInt("id"));
      student.setStudentName(rs.getString("name"));
      student.setCityName(rs.getString("city"));

      return student;
   }
}