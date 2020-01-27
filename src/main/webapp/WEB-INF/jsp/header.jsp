<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" language="java" %>

<html lang="eu">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Weeding Salon</title>
</head>
<body>

<ul class="nav nav-pills">
    <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/news">Новости</a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
           aria-expanded="false">Каталог</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/products/accessories">Аксессуары</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/products/dresses">Платья</a>
        </div>
    </li>
    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/weedingOrders">Список заказов</a>
        </li>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/registration">Регистрация</a>
        </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/users">Список пользователей</a>
        </li>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/login">Авторизация</a>
        </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Выйти</a>
        </li>
    </sec:authorize>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/feedBackForm">Обратная связь</a>
    </li>
</ul>


