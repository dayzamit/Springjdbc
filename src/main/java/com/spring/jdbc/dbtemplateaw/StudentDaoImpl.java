package com.spring.jdbc.dbtemplateaw;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dao.StudentMapper;
import com.spring.jdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDAO {


   @Autowired
   public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
      this.jdbcTemplateObject = jdbcTemplateObject;
   }


   private JdbcTemplate jdbcTemplateObject;
   



   @Override
   public void create(Integer rollId, String name, String city) {
      String SQL = "insert into Student (id,name, city) values (?, ?,?)";
      jdbcTemplateObject.update( SQL, rollId,name,city);
      System.out.println("Created Record Name = " + name );
   }

   public Student getStudent(Integer id) {
      String SQL = "select * from Student where id = ?";
      Student student = jdbcTemplateObject.queryForObject(SQL, 
         new Object[]{id}, new StudentMapper());
      
      return student;
   }
   public List<Student> listStudents() {
      String SQL = "select * from Student";
      List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
      return students;
   }
   public void delete(Integer id) {
      String SQL = "delete from Student where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }
   public void update(Integer id, String cityName){
      String SQL = "update Student set city = ? where id = ?";
      jdbcTemplateObject.update(SQL, cityName, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }
}