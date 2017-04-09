<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style type="text/css">
.filter .control-label {
	text-align: left;
}

.filter span {
	display: block;
}
.posterShop{
	width: 240px;
    height: 300px;
    margin-top:15px;
}
.poster{
	width: 140px;
    height: 200px;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<div><img src="/images/shop/${shop.id}.jpg" class="posterShop"></div>
		</div>
		<div class="col-md-9">
			<h2>${shop.titleSh.namePub}</h2>
			<h3>Original title: ${shop.titleSh.book.title}</h3>
			<h3>Author: <a href="/author/${shop.titleSh.book.author.id}">${shop.titleSh.book.author.name} ${shop.titleSh.book.author.surname}</a></h3>
			<h3>Anotation:</h3>
			<div><p>${shop.anotation}</p></div>
		</div>
	</div>
</div>