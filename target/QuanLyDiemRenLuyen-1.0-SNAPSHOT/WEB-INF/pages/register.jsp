<%-- 
    Document   : register
    Created on : May 30, 2024, 6:17:29 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>ĐĂNG KÝ</h1>
<c:url value="/register" var="action" />

<form:form method="post" action="${action}" modelAttribute="NguoiDung">
    <div class="form-group mt-3">
        <label for="ten">First Name</label>
        <form:input type="text" id="ten" path="ten" class="form-control" /> 
    </div>
    <div class="form-group mt-3">
        <label for="ho">Last Name</label>
        <form:input type="text" id="ho" path="ho" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="birth">Birth</label>
        <form:input type="text" id="birth" path="namSinh" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="gender" me-3>Gender</label>
        <label>
            <input type="radio" id="gender" name="gioiTinh" path="gioiTinh" value="0"> Nam
        </label>
        <label>
            <input type="radio" id="gender"  name="gioiTinh"  path="gioiTinh" value="1"> Nữ
        </label>
        <br>
    </div>
<!--    <div class="form-group mt-3">
        <label for="img">Image</label>
        <form:input type="file" id="img" path="avatar" class="form-control" />
    </di-->
    <div class="form-group mt-3">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="con password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="cofirm-password">Confirm-Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
    <div class="mt-3">
        <input class="btn btn-info" type="submit" value="Đăng ký">
    </div>
</form:form>


