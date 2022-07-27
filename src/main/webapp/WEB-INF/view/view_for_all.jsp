<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: firso
  Date: 26.07.2022
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Страница для всех</h3>
<br>
<security:authorize access="hasRole('BOSS')">
    Только для директора -  <input type="button" value="Директор" onclick="window.location.href = 'boss_page'">
</security:authorize>

<br>
<security:authorize access="hasRole('ADMIN')">
Только для админа - <input type="button" value="Админ" onclick="window.location.href = 'admin_page'">
</security:authorize>
</body>
</html>
