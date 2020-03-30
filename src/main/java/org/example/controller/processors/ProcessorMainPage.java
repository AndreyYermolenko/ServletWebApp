package org.example.controller.processors;


import org.example.model.ProcessorResult;
import org.example.model.Student;

import javax.servlet.http.HttpServletRequest;

import static org.example.dao.StudentsList.addStudent;

public class ProcessorMainPage extends Processor {
    public ProcessorMainPage() {
        action = "mainPage";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        request.getSession().setAttribute("userName", userName);
        addStudent(new Student(userName));

        return new ProcessorResult("/main", "", true);
    }
}
