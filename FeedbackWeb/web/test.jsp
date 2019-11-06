<%-- 
    Document   : test
    Created on : 10 Apr, 2019, 2:04:48 AM
    Author     : sashankbajaru
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String name=request.getParameter("uname");
        String rating=request.getParameter("star");
    %>
    <body>
        <h1>Hello World!</h1>
        <%= rating%>
    </body>
</html>
