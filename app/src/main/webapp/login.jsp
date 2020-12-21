<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>IT-Academy Project - Авторизация</title>
</head>
<body>
<a href="/">Главная страница</a>
<h3>Авторизация</h3>
<form action="login.do" method="post">
    <p>
        <label>Логин: <input name="login" type="text" placeholder="Введите логин"></label><br>
        <label>Пароль: <input name="password" type="password" placeholder="Введите пароль"></label><br>
        <input type="submit" value="Войти">
    </p>
</form>
</body>
</html>

