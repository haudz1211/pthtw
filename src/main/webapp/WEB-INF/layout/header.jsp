<%-- 
    Document   : header
    Created on : May 7, 2024, 2:54:16 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-red">
   <a class="navbar-brand""><img width="300px" src="<c:url value="/images/logo.png"/>"></a>

    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Điều</a>
                    <ul class="dropdown-menu">
                        <li>
                            <c:forEach items="${dieus}" var="c">
                                <c:url var="myUrl" value="/">
                                    <c:param name="dieuId" value="${c.id}"/>
                                </c:url>
                                <a class="dropdown-item" href="${myUrl}">Điều ${c.dieu}</a>
                            </c:forEach>
                        </li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Tính năng</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item btn-info" href="<c:url value="/indexbv" />">Bảng tin</a></li>
                        <li><a class="dropdown-item btn-info" href="<c:url value="/stats" />">Thống kê</a></li>
                                                <li><a class="dropdown-item btn-info" href="<c:url value="/" />">Hoạt Động</a></li>

                        <!--<li><a class="dropdown-item" href="#">Hỏi đáp</a></li>-->
                    </ul>
                </li>

                <li>
                    <form action="<c:url value="/" />" class="d-flex">
                        <input class="form-control me-2" name="kw" type="text" placeholder="Search">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </form>
                </li>

                <li class="navbar-nav ">
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal == null}">
                        <li class="nav-item">
                            <a class="btn btn-info" href="<c:url value='/login' />">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-info" href="<c:url value='/register' />">Đăng Ký</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal != null}">
                        <li class="nav-item">
                            <a class="btn btn-danger me-1" href="<c:url value='/' />">Chào ${pageContext.request.userPrincipal.name}!</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-info" href="<c:url value='/logout' />">Đăng xuất</a>
                        </li>
                    </c:when>
                </c:choose>
                </li>
            </ul>

        </div>
    </div>
</nav>

