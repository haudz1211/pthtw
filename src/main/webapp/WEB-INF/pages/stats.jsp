<%-- 
    Document   : stats
    Created on : May 9, 2024, 12:04:53 AM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1 class="text-center text-info">THỐNG KÊ BÁO CÁO</h1>


<div class="row">
    <div class="col-mt-5 col-12">
        <table class="table">
            <tr>
                <th>Id Sinh Viên</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Lớp</th>
                <th>Khoa</th>
                <th>Điểm Rèn Luyện</th>



                <th></th>
            </tr>
            <tbody>
                <c:forEach items="${sinhVienHoatDongs}" var="c"> 
                    <tr>
                        <td>${c.id}</td>                        
                        <td>${c.sinhVienId.getHo()}</td>
                        <td>${c.sinhVienId.getTen()}</td>
                        <td>${c.sinhVienId.getLopId().getTen()}</td>
                        <td>${c.sinhVienId.getLopId().getKhoaId().getTen()}</td>
                        <td>${c.hoatDongId.getDiem()}</td>



                        <c:url value="/stats/${c.id}" var="url"/>

                        <sec:authorize access="hasRole('ROLE_ASISTANT') or hasRole('ROLE_ADMIN')">
                            <td>
                                <a href="<c:url value="/stats/${c.id}" />" class="btn btn-info">Cập nhật</a>
                                <button onclick="deleteSinhVienHoatDong('${c.id}')" class="btn btn-danger">Xóa</button>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>
</div>