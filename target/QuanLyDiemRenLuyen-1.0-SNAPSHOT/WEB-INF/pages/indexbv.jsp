<%-- 
    Document   : indexbv
    Created on : Jun 20, 2024, 10:06:22 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="mt-1">
     <sec:authorize access="hasRole('ROLE_ASISTANT') or hasRole('ROLE_ADMIN')">
        <div>
            <a href="<c:url value="/home/baiviets" />" class="btn btn-info">Đăng ký hoạt động</a>
        </div>
    </sec:authorize>


    <table class="table table-striped mt-1">

        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Ngày Tạo</th>
            <th>Nội Dung</th>
            <th>Hoạt Động</th>
<!--            <th>Điểm</th>
            <th>Điều</th>
            <th>Khoa</th>
            <th>Học kì</th>
            <th>Năm</th>
            <th>Trợ lý tạo ra</th>-->
            <th></th>
        </tr>

        <tbody>
            <c:forEach items="${baiViets}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.ten}</td>
                    <td>${c.ngayTao}</td>
                    <td>${c.noiDung}</td>
                    <td>${c.hoatDongId.getTen()}</td>
                    <c:url value="/home/baiviets/${c.id}" var="url"/>

                    <sec:authorize access="hasRole('ROLE_ASISTANT') or hasRole('ROLE_ADMIN')">
                        <td>
                            <a href="<c:url value="/home/baiviets/${c.id}" />" class="btn btn-info">Cập nhật</a>
                            <button onclick="deleteBaiViet('${c.id}')" class="btn btn-danger">Xóa</button>
                        </td>
                    </sec:authorize>

                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>
<script src="<c:url value="/js/script.js" />"></script>

<script>
    function deleteBaiViet(id) {
    if (confirm("Bạn có chắc chắn muốn xóa bài viết này?")) {
        // Thực hiện yêu cầu xóa hoạt động
        // Ví dụ sử dụng AJAX để gửi yêu cầu xóa
        $.ajax({
            url: '/home/baiviets/' + id,
            type: 'DELETE',
            success: function (result) {
                // Xử lý sau khi xóa thành công
                alert("Đã xóa hoạt động thành công");
                location.reload();
            },
            error: function (err) {
                // Xử lý lỗi
                alert("Xóa hoạt động thất bại");
            }
        });
    }
}
</script>   
