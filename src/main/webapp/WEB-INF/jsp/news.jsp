<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<div class="news-container" style="
    background-size: 100% auto;
    background-position: center;
    background-image: url(https://www.blackpantera.ru/articles/wp-content/uploads/2019/12/wedding-broker-prueba-vestido.jpg);
    height: 100%;">
    <div>
        <div style="width: 100%; height: 50%; float: left; margin-top:10%">
<c:forEach var="news" items="${newss}">
    <div style="float: left; width: 50%; background: white; text-align:center;"><div class="news-title" style="text-align:center"><b>${news.title}</b></div>
                ${news.description}<br>
                <a href="${news.link}">Перейти</a>
        <c:choose>
            <c:when test="${news.id eq 1}">
                <hr>
            </c:when>
            <c:when test="${news.id eq 2}">
                <hr>
            </c:when>
        </c:choose>
            </div>
</c:forEach>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>