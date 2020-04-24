<%@ page import="org.example.controller.processors.ProcessorShowAllStudents" %>
<%@ page import="org.example.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
