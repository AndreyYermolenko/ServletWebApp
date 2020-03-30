<%--
  Created by IntelliJ IDEA.
  User: olbe0615
  Date: 17.02.2020
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<div>Hello, <%= session.getAttribute("userName") %></div>
</br>
<div><a href="/test?action=logOut">Exit</a></div>

<div>
    Menu:
    <ul>
        <li>
            <a href="/test?action=showAllStudents">Students</a>
        </li>
    </ul>
</div>

<div>
    Main part:
    <% String includedPage = (String) session.getAttribute("includedPage"); %>
    <% if (includedPage != null && !includedPage.isEmpty()) { %>
        <jsp:include page="<%= includedPage %>" />
    <% } %>
</div>

</body>
</html>
