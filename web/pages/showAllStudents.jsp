<%@ page import="org.example.controller.processors.ProcessorShowAllStudents" %>
<%@ page import="org.example.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 24.02.2020
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <% List<Student> studentsList = (List<Student>) session.getAttribute("studentsList"); %>
        <% for (Student student: studentsList) { %>
            <ul>
                <li>
                    <%= student.getId() %>
                    <%= student.getName() %> <br/>
                </li>
            </ul>
        <% } %>
    </div>
</body>
</html>

<%--<input type="checkbox" name="students" value="<%= student.getId() %>" /> --%>
