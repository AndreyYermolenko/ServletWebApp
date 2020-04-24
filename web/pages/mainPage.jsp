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
