<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="/WEB-INF/part/head.jsp"/>
    <link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<main class="form-signin">
    <form action="login.do" method="post">
        <img class="mb-4" src="img/icon.png" alt="" width="128" height="128">
        <h1 class="h1 mb-3 fw-normal">Free Book</h1>
        <h4 class="h4 mb-3 fw-normal">Please sign in</h4>
        <c:if test="${ERROR_AUTH != null}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <c:out value="${ERROR_AUTH}"/>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <label for="email" class="visually-hidden">Email address</label>
        <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
        <label for="password" class="visually-hidden">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me">
                Remember me
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
    </form>
</main>
<c:import url="/WEB-INF/part/script.jsp"/>
</body>
</html>