<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="products-container" style="text-align: center;
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">

    <div class="products-h1"><h1>Список продукции</h1></div>

    <table class="table table-striped" style="background: white">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Имя</th>
            <th scope="col">Цвет</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
        <tr>
            <th scope="row">${product.productId}</th>
            <td><a href="${pageContext.request.contextPath}/products/buy/${product.productId}">${product.name}</a></td>

            <c:forEach var="color" items="${colors}">
                <c:choose>
                    <c:when test="${color.colorId eq product.colorId}">
                        <td>${color.name}</td>
                    </c:when>
                </c:choose>
            </c:forEach>

            <td>${product.cost}</td>
        </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>