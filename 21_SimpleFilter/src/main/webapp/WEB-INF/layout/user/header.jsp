<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style type="text/css">
.searchBox {
	background-color: #2874f0;
}
</style>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="/delivery">Delivery</a></li>
			<li><a href="/payment">Payment</a></li>
			<li><a href="/contact">Contact</a></li>
			<li><a href="/about">About us</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/login">Login</a></li>
		</ul>
	</div>
</nav>
<div class="row searchBox">
	<div class="col-md-3">
		<h2 style="color: white">BookShop</h2>
	</div>
	<div class="col-md-5">
		<form class="form-inline" action="/admin/category" method="GET">
			<custom:hiddenInputs excludeParams="search" />
			<div class="form-group">
				<input class="form-control" placeholder="Search" />
			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>
</div>