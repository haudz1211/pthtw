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

<hr>

<h3 class="text-center text-info">THỐNG KÊ THEO THÀNH TÍCH CỦA CÁC KHOA</h3>
<div class="row">
    <div class="col-md-5 col-12">
        <form>
            <div class="form-floating">
                <select class="form-select" id="THANHTHICH" name="thanhtich">
                    <option value="XUATSAC" >Xuất sắc</option>
                    <option value="GIOI">Giỏi</option>
                    <option value="KHA" >Khá</option>
                </select>
                <label for="THANHTHICH" class="form-label">CHỌN THÀNH TÍCH</label>
            </div>
            <div class="form-floating">
                <select class="form-select" id="namHoc-khoa" name="namHoc">
                    <c:forEach items="${namHocs}" var="c">
                        <option value="${c.namHoc}" >${c.namHoc}</option>
                    </c:forEach>
                </select>
                <label for="namHoc-khoa" class="form-label">CHỌN NĂM HỌC</label>
            </div>
            <div class="form-floating">
                <select class="form-select" id="hocKi-khoa" name="hocKi">
                    <c:forEach items="${hocKis}" var="c">
                        <option value="${c.hocKi}" >${c.hocKi}</option>
                    </c:forEach>
                </select>
                <label for="hocKi-khoa" class="form-label">CHỌN HỌC KÌ</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class='btn btn-success'>Lọc</button>
            </div>
        </form>
        <table class="table">
            <tr>
                <th>Khoa</th>
                <th>Số lượng</th>
            </tr>
            <c:forEach items="${statsTheoThanhTichVaTheoKhoa}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart"></canvas>
    </div>
</div>
<hr>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/script.js" />"></script>
<script>
    let labels = [];
    let data = [];
    <c:forEach items="${statsTheoThanhTichVaTheoKhoa}" var="c">
    labels.push('${c[0]}');
    data.push('${c[1]}');

    </c:forEach>
    let labels2 = [];
    let data2 = [];
    <c:forEach items="${statsTheoThanhTichVaTheoLop}" var="c">
    labels2.push('${c[0]}');
    data2.push('${c[1]}');
    </c:forEach>
    let labels3 = [];
    let data3 = [];
    <c:forEach items="${statsDiemRenLuyenTheoThanhTich}" var="c">
    labels3.push('${c[0]}');
    data3.push('${c[1]}');
    </c:forEach>

    window.onload = function () {
        let ctx1 = document.getElementById("myChart");
        let ctx2 = document.getElementById("myChart2");
        let ctx3 = document.getElementById("myChart3");




        drawChartTheoKhoa(ctx1, labels, data, "THỐNG KÊ TOÀN TRƯỜNG");
        drawChartTheoKhoa(ctx2, labels2, data2, 'THỐNG KÊ TOÀN KHOA');
        drawChartTheoKhoa(ctx3, labels3, data3, 'THỐNG KÊ TOÀN LỚP');
    };
</script>