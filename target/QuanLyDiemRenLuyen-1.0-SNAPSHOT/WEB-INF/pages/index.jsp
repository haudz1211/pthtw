<%-- 
Document   : index
Created on : May 5, 2024, 1:05:13 AM
Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="mt-1">
     <sec:authorize access="hasRole('ROLE_ASISTANT') or hasRole('ROLE_ADMIN')">
        <div>
            <a href="<c:url value="/admin/hoatdongs" />" class="btn btn-info">Thêm hoạt động</a>
        </div>
    </sec:authorize>


    <table class="table table-striped mt-1">

        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Mô Tả</th>
            <th>Điểm</th>
            <th>Điều</th>
            <th>Khoa</th>
            <th>Học kì</th>
            <th>Năm</th>
            <th>Trợ lý tạo ra</th>
            <th></th>
        </tr>

        <tbody>
            <c:forEach items="${hoatDongs}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.ten}</td>
                    <td>${c.moTa}</td>
                    <td>${c.diem}</td>
                    <td>${c.dieuId.getDieu()}</td>
                    <td>${c.khoaId.getTen()}</td>
                    <td>${c.hocKiNamHocId.getHocKiId().getHocKi()}</td>
                    <td>${c.hocKiNamHocId.getNamHocId().getNamHoc()}</td>                     
                    <td>${c.troLyId.getNguoiDung().getHo()}  ${c.troLyId.getNguoiDung().getTen()}</td>
                    <c:url value="/admin/hoatdongs/${c.id}" var="url"/>

                    <sec:authorize access="hasRole('ROLE_ASISTANT') or hasRole('ROLE_ADMIN')">
                        <td>
                            <a href="<c:url value="/admin/hoatdongs/${c.id}" />" class="btn btn-info">Cập nhật</a>
                            <button onclick="deleteHoatDong('${c.id}')" class="btn btn-danger">Xóa</button>
                        </td>
                    </sec:authorize>



                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>
<script src="<c:url value="/js/script.js" />"></script>

<script>
    function deleteHoatDong(id) {
    if (confirm("Bạn có chắc chắn muốn xóa hoạt động này?")) {
        // Thực hiện yêu cầu xóa hoạt động
        // Ví dụ sử dụng AJAX để gửi yêu cầu xóa
        $.ajax({
            url: '/admin/hoatdongs/' + id,
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


