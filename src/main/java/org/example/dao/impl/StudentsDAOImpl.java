package org.example.dao.impl;

import org.example.dao.ConnectionPool;
import org.example.dao.StudentsDAO;
import org.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.ConnectionPool.getConnectionPool;

public class StudentsDAOImpl implements StudentsDAO {

    private static volatile StudentsDAO studentsDAO;
    private ConnectionPool connectionPool;

    private StudentsDAOImpl() {
        connectionPool = getConnectionPool();
    }

    public static StudentsDAO getStudentsDAO() {
        if (studentsDAO == null) {
            synchronized (ConnectionPool.class) {
                if (studentsDAO == null) {
                    studentsDAO = new StudentsDAOImpl();
                }
            }
        }
        return studentsDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        Connection connection = connectionPool.getConnection();
        List<Student> list = new ArrayList<>();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM students"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));

                list.add(student);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addStudent(Student student) {
        Connection connection = connectionPool.getConnection();

        String name = student.getName();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO students (name) VALUES (?)"
            );

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


