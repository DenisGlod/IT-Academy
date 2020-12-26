<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IT-Academy Project - Администратор</title>
</head>
<body>
<h1>Администратор</h1>
<form action="/logout.do" method="post">
    <input type="submit" name="logout" value="Выйти">
</form>
<div>
    <p><c:out value="${user.fio}"/></p>
    <hr>
</div>
<a href="/adduser">Добавить пользователя</a> |
<a href="/userlist">Список пользователей</a>

</body>
</html>
