package org.example.controller.processors;


import org.example.dao.StudentsDAO;
import org.example.model.ProcessorResult;
import org.example.model.Student;

import javax.servlet.http.HttpServletRequest;

import static org.example.dao.impl.StudentsDAOImpl.getStudentsDAO;

public class ProcessorMainPage extends Processor {

    private StudentsDAO studentsDAO;

    public ProcessorMainPage() {
        studentsDAO = getStudentsDAO();
        action = "mainPage";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        request.getSession().setAttribute("userName", userName);
        studentsDAO.addStudent(new Student(userName));

        return new ProcessorResult("/main", "", true);
    }
}
