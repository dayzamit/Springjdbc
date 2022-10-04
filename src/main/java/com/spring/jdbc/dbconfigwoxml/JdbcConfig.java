package com.spring.jdbc.dbconfigwoxml;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dbtemplate.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {


    @Bean(name = {"ds"})
    public  DataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }

    @Bean(name = {"jdbcTemplateObject"})
    public JdbcTemplate getJdbcTemplate()
    {
        JdbcTemplate jdbcTemplate= new JdbcTemplate();
        jdbcTemplate.setDataSource(driverManagerDataSource());
        return  jdbcTemplate;
    }

    @Bean(name = {"studentDaoImpl"})
    public StudentDAO getStudentDAO()
    {
      StudentDAO studentDAO=new StudentDaoImpl();

        ((StudentDaoImpl)studentDAO).setJdbcTemplateObject(getJdbcTemplate());
      return studentDAO;
    }


}
