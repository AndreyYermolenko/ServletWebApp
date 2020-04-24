package org.example.dao;

import org.example.model.Student;

import java.util.List;

public interface StudentsDAO {

    List<Student> getAllStudents();

    void addStudent(Student student);

}
