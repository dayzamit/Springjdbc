package com.spring.jdbc;


import com.spring.jdbc.dbtemplateaw.StudentDaoImpl;

import com.spring.jdbc.model.Student;
import com.spring.jdbc.studentdawoaw.JdbcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
 loadDatabaseViaAnnotation();
    }

    public static void loadDatabaseViaAnnotation()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDaoImpl studentJDBCTemplate =
                (StudentDaoImpl)context.getBean("studentDaoImpl");

        System.out.println("------Records Creation--------"  + studentJDBCTemplate);

        // studentJDBCTemplate.create(7009,"Deere","John");

        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();

        for (Student record : students) {
            System.out.print("ID : " + record.getStudentId() );
            System.out.print(", Name : " + record.getStudentName() );
            System.out.println(", Age : " + record.getCityName());
        }
   /*     System.out.println("----Updating Record with ID = 2 -----" );
        studentJDBCTemplate.update(7001, "Indore");

        System.out.println("----Listing Record with ID = 2 -----" );

        System.out.println(studentJDBCTemplate.getStudent(7001));*/
    }

    public static void loadDatabaseViaXML()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
        StudentDaoImpl studentJDBCTemplate =
                (StudentDaoImpl)context.getBean("studentDaoImpl");

        System.out.println("------Records Creation--------"  + studentJDBCTemplate);

        // studentJDBCTemplate.create(7009,"Deere","John");

        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();

        for (Student record : students) {
            System.out.print("ID : " + record.getStudentId() );
            System.out.print(", Name : " + record.getStudentName() );
            System.out.println(", Age : " + record.getCityName());
        }
   /*     System.out.println("----Updating Record with ID = 2 -----" );
        studentJDBCTemplate.update(7001, "Indore");

        System.out.println("----Listing Record with ID = 2 -----" );

        System.out.println(studentJDBCTemplate.getStudent(7001));*/
    }

}
