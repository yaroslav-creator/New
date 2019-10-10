package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    public String name;
    public int age;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxGrade = 0.0;
        Student maxStudent = null;
        for (Student student : students) {
            if (student.getAverageGrade() > maxGrade) {
                maxGrade = student.getAverageGrade();
                maxStudent = student;
            }
        }
        return maxStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minGrade = students.get(0).getAverageGrade();
        Student minStudent = null;
        for (Student student : students) {
            if (student.getAverageGrade() < minGrade) {
                minGrade = student.getAverageGrade();
                minStudent = student;
            }
        }
        return minStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}