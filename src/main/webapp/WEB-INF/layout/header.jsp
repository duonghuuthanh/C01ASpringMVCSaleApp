<%-- 
    Document   : header
    Created on : Dec 3, 2021, 6:48:49 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">My SaleApp</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/" />">Trang chu</a>
        </li>
        
        <c:forEach items="${categories}" var="c">
            <li class="nav-item">

                <c:url value="/" var="action">
                    <c:param name="cateId" value="${c.id}" />
                </c:url>

                <a class="nav-link" href="${action}">${c.name}</a>
            </li>
        </c:forEach>
        <li class="nav-item">
          <a class="nav-link text-danger" href="<c:url value="/cart" />">
              Gio hang <span class="badge badge-info cartCounter">${cartStats.totalQuantity}</span>
          </a>
        </li>
      </ul>
    </div>

    <c:url value="/" var="action" />
    <form class="form-inline" action="${action}" >
        <input class="form-control mr-sm-2" type="text" name="kw" placeholder="Nhap tu khoa...">
        <button class="btn btn-success" type="submit">Tim kiem</button>
    </form>
</nav>