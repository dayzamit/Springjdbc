package com.spring.jdbc.studentdawoaw;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dbtemplate.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dbtemplateaw"})
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



}
