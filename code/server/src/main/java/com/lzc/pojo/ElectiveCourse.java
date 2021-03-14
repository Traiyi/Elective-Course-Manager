package com.lzc.pojo;

public class ElectiveCourse {
    private int id;
    private String name;
    private int gradeID;
    private int specialtyID;
    private double credit;
    private int studentQuantity;
    private Grade grade;
    private Specialty specialty;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

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

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getSpecialtyID() {
        return specialtyID;
    }

    public void setSpecialtyID(int specialtyID) {
        this.specialtyID = specialtyID;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(int studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    @Override
    public String toString() {
        return "ElectiveCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gradeID=" + gradeID +
                ", specialtyID=" + specialtyID +
                ", credit=" + credit +
                ", studentQuantity=" + studentQuantity +
                '}';
    }
}
