<%-- 
    Document   : stats
    Created on : May 9, 2024, 12:04:53 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">THỐNG KÊ BÁO CÁO</h1>

<div class="row">
    <div class="col-mt-5 col-12">
        <table class="table">
            <tr>
                <th>Id Sinh Viên</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Năm Sinh</th>
                <th>Lớp</th>
                <th>Điểm rèn luyện</th>
                <th></th>
            </tr>
            <c:forEach items="${sinhViens}" var="c"> 
                <tr>
                    <td>${c.id}</td>                 
                    <td>${c.ho}</td>
                    <td>${c.ten}</td>
                    <td>${c.namsinh}</td>
                    <!--<td>${c.lopId.getTen()}</td>-->
                    <td><a class="btn  btn-success" href="<c:url value="/sinhvien/${c[0]}" />">XEM CHI TIẾT</a></td>    
                </tr>
            </c:forEach>
        </table>
    </div>
</div>