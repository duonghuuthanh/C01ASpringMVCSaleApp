<%-- 
    Document   : products
    Created on : Dec 3, 2021, 6:53:02 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>



<h1 class="text-center text-info">QUAN LY SAN PHAM</h1>

<c:if test="${errMsg != null}">
<div class="alert alert-danger">
    ${errMsg}
</div>
</c:if>

<c:url value="/admin/products" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="product">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-group">
        <label for="name">Ten san pham</label>
        <form:input path="name" class="form-control" id="name" />
        <form:errors path="name" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="description">Mo ta</label>
        <form:textarea path="description" class="form-control" id="description" />
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="name">Gia ban</label>
        <form:input path="price" class="form-control" id="price" />
        <form:errors path="price" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="name">Danh muc</label>
        <form:select path="categoryId" class="form-control">
            <c:forEach items="${categories}" var="c">
                <form:option value="${c.id}">${c.name}</form:option> 
            </c:forEach>
        </form:select>
    </div>
   
    <div class="form-group">
        <label for="file">Anh san pham</label>
        <form:input type="file" path="file" 
                    class="form-control" id="file" />
    </div>
    
    <input type="submit" value="Them san pham" class="btn btn-danger" />
</form:form>
<br><br>
