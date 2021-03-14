package com.lzc.pojo;

public class Elective {
    private int id;
    private String name;
    private int courseID;
    private int studentID;
    private double studentCredit;
    private int isPass;
    private Student student;
    private ElectiveCourse electiveCourse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getStudentCredit() {
        return studentCredit;
    }

    public void setStudentCredit(double studentCredit) {
        this.studentCredit = studentCredit;
    }

    public int getIsPass() {
        return isPass;
    }

    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ElectiveCourse getElectiveCourse() {
        return electiveCourse;
    }

    public void setElectiveCourse(ElectiveCourse electiveCourse) {
        this.electiveCourse = electiveCourse;
    }

    @Override
    public String toString() {
        return "Elective{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseID=" + courseID +
                ", studentID=" + studentID +
                ", studentCredit=" + studentCredit +
                ", isPass=" + isPass +
                ", student=" + student +
                ", electiveCourse=" + electiveCourse +
                '}';
    }
}
