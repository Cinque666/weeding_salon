<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${pageContext.request.contextPath}/add" method="POST" enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Название</label>
        <input type="text" name="name" class="form-control" id="name" placeholder="Введите название">
    </div>

    <div class="form-group">
        <label for="cost">Цена</label>
        <input type="number" name="cost" class="form-control" id="cost" placeholder="Введите цену">
    </div>

    <div class="form-group">
        <label for="colorId">Цвет</label>
        <input type="number" name="colorId" class="form-control" id="colorId" placeholder="Введите цвет">
    </div>

    <div class="form-group">
        <label for="exampleFormControlFile1">Изображение</label>
        <input type="file" name="image" class="form-control-file" id="exampleFormControlFile1">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>