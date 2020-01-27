<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>

<div class="product-container" style="text-align: center;
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">
    <h1>Регистрация заказа</h1>
<form action="${pageContext.request.contextPath}/products/addOrder" method="POST">
    <div class="form-group" style="width: 30%; margin-left:35%">
        <select name="productName" id="productName" class="form-control">
                <option>${product.name}</option>
        </select>
    </div>

    <div class="form-group" style="width: 30%; margin-left:35%">
        <select name="login" id="login" class="form-control">
        <c:forEach var="customer" items="${customers}">
            <option>${customer.login}</option>
        </c:forEach>
        </select>
    </div>

    <div class="form-group" style="width: 30%; margin-left:35%">
        <select name="productPrice" id="productPrice" class="form-control">
                <option>${product.cost}</option>
        </select>
    </div>

    <button type="submit" class="btn btn-primary reg-btn">Submit</button>
</form>
</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>