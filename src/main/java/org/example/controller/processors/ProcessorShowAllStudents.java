package org.example.controller.processors;


import org.example.dao.StudentsDAO;
import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

import static org.example.dao.impl.StudentsDAOImpl.getStudentsDAO;

public class ProcessorShowAllStudents extends Processor {

    private StudentsDAO studentsDAO;

    public ProcessorShowAllStudents() {
        studentsDAO = getStudentsDAO();
        action = "showAllStudents";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        request.getSession().setAttribute("studentsList", studentsDAO.getAllStudents());

       return new ProcessorResult("/main", "/pages/showAllStudents.jsp", true);
    }
}
