package org.example.controller.processors;


import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

import static org.example.dao.StudentsList.getList;

public class ProcessorShowAllStudents extends Processor {
    public ProcessorShowAllStudents() {
        action = "showAllStudents";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        request.getSession().setAttribute("studentsList", getList());

       return new ProcessorResult("/main", "/pages/showAllStudents.jsp", true);
    }
}
