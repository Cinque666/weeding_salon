<jsp:include page="header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="registration-container" style="text-align: center;
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">

    <div class="products-h1"><h1>Список заказов</h1></div>

    <table class="table table-striped" style="background: white">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Имя клиента</th>
            <th scope="col">Имя продавца</th>
            <th scope="col">Название продукта</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
        <tr>
            <th scope="row">${order.orderId}</th>

            <c:forEach var="appUser" items="${appUsers}">
                <c:choose>
                    <c:when test="${order.clientId eq appUser.appUserId}">
                        <td>${appUser.login}</td>
                    </c:when>
                </c:choose>
            </c:forEach>

            <c:forEach var="appUser" items="${appUsers}">
                <c:choose>
                    <c:when test="${order.clientId eq appUser.appUserId}">
                        <td>${appUser.login}</td>
                    </c:when>
                </c:choose>
            </c:forEach>

            <c:forEach var="product" items="${products}">
                <c:choose>
                    <c:when test="${product.productId eq order.productId}">
                        <td>${product.name}</td>
                    </c:when>
                </c:choose>
            </c:forEach>

            <c:forEach var="product" items="${products}">
                <c:choose>
                    <c:when test="${product.productId eq order.productId}">
                        <td>${product.cost}</td>
                    </c:when>
                </c:choose>
            </c:forEach>

        </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="footer.jsp"/>