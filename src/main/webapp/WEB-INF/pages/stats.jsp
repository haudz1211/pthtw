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
                <th>Giới Tính</th>
                <th>Niên Khóa</th>
                <th>Hoạt Động</th>
                <th>Điểm</th>
                <th>Lớp</th>
                <th>Năm Học</th>
                <th></th>
            </tr>
            <c:forEach items="${}" var="c"> 
                <tr>
                    <td>${c.id}</td>                 
                    <td>${c.ho}</td>
                    <td>${c.ten}</td>
                    <td>${c.namsinh}</td>
                    <td>${c.gioiTinh}</td>
                    <td>${c.nienKhoa}</td>
                    <td>${c.sinhVienHoatDongId.getHoatDongId().getTen()}</td>
                    <td>${c.sinhVienHoatDongId.getHoatDongId().getDiem()}</td>
                    <td>${c.lopId.getTen()}</td>
                    <td>${c.hocKiNamHocId.getNamHocId().getNamHoc()}</td>  
                    <td>
                        <c:url value="/stats/${c.id}" var="url"/>
                    <td>
                        <a class="btn  btn-success" href="<c:url value="/stats/${c[0]}" />">XEM CHI TIẾT</a>

                    </td> 
                    <!--                <sec:authorize access="hasRole('ROLE_ASISTANT') or hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a class="btn  btn-success" href="<c:url value="/stats/${c[0]}" />">XEM CHI TIẾT</a>
                                        </td>    
                    
                                        <td>
                                            <a href="<c:url value="/stats/${c.id}" />" class="btn btn-info">Cập nhật</a>
                                            <button onclick="deleteSinhVien('${c.id}')" class="btn btn-danger">Xóa</button>
                                        </td>
                                    </sec:authorize>-->
                </tr>
            </c:forEach>
        </table>
    </div>
</div>