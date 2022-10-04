package com.spring.jdbc.model;

public class Student {

    public Student() {
    }

    public Student(int studentId, String studentName, String cityName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private int studentId;
    private String studentName;
    private String cityName;
}
