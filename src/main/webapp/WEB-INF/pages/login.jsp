<%-- 
    Document   : login.jsp
    Created on : Dec 12, 2021, 2:47:15 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">DANG NHAP NGUOI DUNG</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Username hoac password KHONG chinh xac!!!
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label>Username</label>
        <input type="text" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" name="password" class="form-control" />
    </div>
    <input type="submit" value="Dang nhap" class="btn btn-danger" />
</form>
<br><br>
