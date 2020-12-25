<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>IT-Academy Project - Главная</title>
</head>
<body>
<h2>Главная страница</h2>
<h3>Авторизация</h3>
<c:if test="${exceptionFlag == true}">
    <p style="color: darkred"><c:out value="${exceptionMessage}"/></p>
</c:if>
<form action="/login.do" method="post">
    <p>
        <label>Логин: <input name="login" type="text" placeholder="Введите логин"></label><br>
        <label>Пароль: <input name="password" type="password" placeholder="Введите пароль"></label><br>
        <input type="submit" value="Войти">
    </p>
</form>
</body>
</html>