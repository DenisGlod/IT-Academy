<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IT-Academy Project - Пользователь</title>
</head>
<body>
<h1>Пользователь</h1>
<form action="/logout.do" method="post">
    <input type="submit" name="logout" value="Выйти">
</form>
<div>
    <p><c:out value="${user.fio}"/></p>
</div>
<table border="1">
    <thead>
    <tr>
        <td>№ группы</td>
        <td>Темы</td>
        <td>Оценки</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="group">
        <c:forEach items="${group.rating}" var="rating">
            <tr>
                <td><c:out value="${group.id}"/></td>
                <td><c:out value="${rating.key}"/></td>
                <td><c:out value="${rating.value}"/></td>
            </tr>
        </c:forEach>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
