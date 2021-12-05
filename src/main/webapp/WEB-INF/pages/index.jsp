<%-- 
    Document   : index
    Created on : Nov 21, 2021, 2:20:05 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">BAN HANG TRUC TUYEN</h1>
        

<c:if test="${products.size() == 0}">
    <div class="alert alert-info">
        Khong co san pham nao!!!
    </div>
</c:if>
<div class="row">
    <c:forEach items="${products}" var="p">
    <div class="col-md-3 col-xs-12" style="padding: 10px;">
        <div class="card">
            <c:if test="${p.image != null && p.image.startsWith('https')}">
                <img class="card-img-top" src="${p.image}" alt="${p.name}">
            </c:if>

           <c:if test="${p.image == null || !p.image.startsWith('https')}">
               <img class="card-img-top" src="<c:url value="/images/my-phone.png" />" alt="${p.name}">
            </c:if>

            <div class="card-body">
              <h4 class="card-title">${p.name}</h4>
              <p class="card-text">${p.price} VND</p>
              <a href="#" class="btn btn-primary" 
                    onclick="addToCart(${p.id}, '${p.name}', ${p.price})">Dat hang</a>
              <a href="#" class="btn btn-danger">Xem chi tiet</a>
            </div>
        </div>
    </div>
    </c:forEach>
</div>

