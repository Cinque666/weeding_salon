<jsp:include page="header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="registration-container" style="text-align: center;
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">

    <div class="registration-h1"><h1>Регистрация</h1></div>

    <form action="${pageContext.request.contextPath}/registration" method="POST">
        <div class="form-group">
            <label for="login">Логин</label>
            <input type="text" name="login" class="form-control" id="login" placeholder="Введите логин" style="width:30%;
    margin-left: 35%;">
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Введите пароль" style="width:30%;
    margin-left: 35%;">
        </div>

        <button type="submit" class="btn btn-primary reg-btn">Submit</button>
    </form>

    ${message}

</div>

<jsp:include page="footer.jsp"/>