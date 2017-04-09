<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h2>${book.title}</h2>
     <div class="row">
			<div class="col-md-3 col-xs-3"><h3>Author name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Author surname</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Publisher</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Seria of publishing</h3></div>
		</div>
		<c:forEach items="${shops}" var="shop">
    <div class="row">
    	<div class="col-md-3 col-xs-3"><a href="/author/${shop.shbook.author.id}">${shop.shbook.author.name}</a></div>
    	<div class="col-md-3 col-xs-3"><a href="/author/${shop.shbook.author.id}">${shop.shbook.author.surname}</a></div>
    	<div class="col-md-3 col-xs-3"><a href="/publisher/${shop.shSeria.publisher.id}">${shop.shSeria.publisher.name}</a></div>
    	<div class="col-md-3 col-xs-3">${shop.shSeria.nameOfS}</div>
    	</div>
    </c:forEach>