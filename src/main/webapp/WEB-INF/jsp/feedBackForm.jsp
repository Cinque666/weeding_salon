<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="feedBackForm-container" style="text-align: center;
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">

    <h1>Форма обратной связи</h1>
<form action="${pageContext.request.contextPath}/feedBackForm" method="POST">
    <div class="form-group">
        <label for="name">Ваше имя</label>
        <input type="text" name="name" class="form-control" id="name" placeholder="" style="width:30%;
    margin-left: 35%;">
    </div>
    <div class="form-group">
        <label for="email">Ваш e-mail</label>
        <input type="email" name="email" class="form-control" id="email" placeholder="" style="width:30%;
    margin-left: 35%;">
    </div>
    <div class="form-group">
        <label for="description">Вопрос</label>
        <input type="text" name="description" class="form-control" id="description" placeholder="" style="width:30%;
    margin-left: 35%;">
    </div>

    <button type="submit" class="btn btn-primary reg-btn">Submit</button>
</form>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>