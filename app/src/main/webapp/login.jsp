<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>IT-Academy Project - Авторизация</title>
</head>
<body>
<a href="/">Главная страница</a>
<h3>Авторизация</h3>
<c:if test="${requestScope.get('exceptionFlag') == true}">
    <p style="color: darkred"><c:out value="${exceptionMessage}"/></p>
</c:if>
<form action="login.do" method="post">
    <p>
        <label>Логин: <input name="login" type="text" placeholder="Введите логин"></label><br>
        <label>Пароль: <input name="password" type="password" placeholder="Введите пароль"></label><br>
        <input type="submit" value="Войти">
    </p>
</form>
</body>
</html>

