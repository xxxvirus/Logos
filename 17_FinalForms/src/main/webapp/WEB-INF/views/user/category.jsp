<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <h2>${category.nameOfC}</h2>
   <div class="row">
			<div class="col-md-3 col-xs-3"><h3>Book title</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Book pages</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Year of Publish</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Price</h3></div>
		</div>
    <c:forEach items="${shops}" var="shop">
    <div class="row">
    	<div class="col-md-3 col-xs-3"><a href="/book/${shop.shbook.id}">${shop.shbook.title}</a></div>
    	<div class="col-md-3 col-xs-3">${shop.shbook.pages}</div>
    	<div class="col-md-3 col-xs-3">${shop.shyear}</div>
    	<div class="col-md-3 col-xs-3">${shop.shprice}</div>
    	</div>
    </c:forEach>
    <c:if test="${empty shops}">
	<h3>Category is empty</h3>
</c:if>