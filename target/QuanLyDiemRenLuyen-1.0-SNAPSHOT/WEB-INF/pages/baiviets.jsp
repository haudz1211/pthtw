
<%-- 
    Document   : baiviets
    Created on : Jun 14, 2024, 12:39:04 PM
    Author     : ADMIN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">BÀI VIẾT HOẠT ĐỘNG ĐIỂM RÈN LUYỆN</h1>
<c:url value="/home/baiviets" var="actions" />
<form:form action="${actions}" modelAttribute="baiViet" method="post">
    <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ten" placeholder="Nhập tên bài viết" path="ten" />
        <label for="ten">Tên bài viết</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="noidung" placeholder="Nhập nội dung bài viet" path="noiDung" />
        <label for="noidung">Mô tả nội dung</label>
    </div>

<!--    <div class="form-floating mb-3 mt-3">
        
        <label for="hoatDongId" class="form-label">Hoạt động</label>
    </div>-->

    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="hoatDongId" path="hoatDongId">
            <c:forEach items="${hoatDongs}" var="c">
                <c:choose>
                    <c:when test="${c.id==baiViet.hoatDongId.id}">
                        <option value="${c.id}" selected>${c.ten}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.ten}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="hoatDongId" class="form-label">Hoạt động</label>
    </div>


    <div class="form-floating mb-3 mt-3">
       
        <form:input type="datetime-local" path="ngayTao" min="1995-06-02"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${baiViet.id > 0}">Cập nhật thông tin</c:when>
                <c:otherwise>Thêm bài viết </c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id"/>
    </div>


</form:form>


