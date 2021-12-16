<%-- 
    Document   : register
    Created on : Dec 12, 2021, 3:23:43 PM
    Author     : duonghuuthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">DANG KY NGUOI DUNG</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />

<form:form method="post" 
           enctype="multipart/form-data"
           action="${action}" 
           modelAttribute="user">
    <div class="form-group">
        <label>First name</label>
        <form:input path="firstName" class="form-control"  />
    </div>
    <div class="form-group">
        <label>Last name</label>
        <form:input path="lastName" class="form-control" />
    </div>
    <div class="form-group">
        <label>Email</label>
        <form:input path="email" class="form-control" />
    </div>
    <div class="form-group">
        <label>Username</label>
        <form:input path="username" class="form-control" />
    </div>
    <div class="form-group">
        <label>Password</label>
        <form:password path="password" class="form-control" />
    </div>
    <div class="form-group">
        <label>Confirm password</label>
        <form:password path="confirmPassword" class="form-control" />
    </div>
    <div class="form-group">
        <label>Avatar</label>
        <form:input type="file" path="file" class="form-control" />
    </div>
    <input type="submit" value="Dang ky" class="btn btn-danger" />
</form:form>
<br><br>
