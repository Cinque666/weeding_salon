<jsp:include page="header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="users-container" style="text-align: center;
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">

    <div class="users-h1"><h1>Список зарегистрированных пользователей</h1></div>

    <table class="table table-striped" style="background: white">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Логин</th>
            <th scope="col">Роль</th>
            <th scope="col">Повысить</th>
            <th scope="col">Понизить</th>
            <th scope="col">Удалить</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="appUser" items="${appUsers}">
        <tr>
            <th scope="row">${appUser.appUserId}</th>
            <td>${appUser.login}</td>
            <c:choose>
                <c:when test="${appUser.roleId == 1}">
                    <td>Админ</td>
                </c:when>
                <c:when test="${appUser.roleId == 2}">
                    <td>Менеджер</td>
                </c:when>
                <c:when test="${appUser.roleId == 3}">
                    <td>Клиент</td>
                </c:when>
            </c:choose>
            <td><a href="${pageContext.request.contextPath}/users/up/${appUser.appUserId}">Повысить</a></td>
            <td><a href="${pageContext.request.contextPath}/users/down/${appUser.appUserId}">Понизить</a></td>
            <td><a href="${pageContext.request.contextPath}/users/delete/${appUser.appUserId}">Удалить</a></td>
        </tr>
        </c:forEach>
    </table>

    ${message}
</div>

<jsp:include page="footer.jsp"/>