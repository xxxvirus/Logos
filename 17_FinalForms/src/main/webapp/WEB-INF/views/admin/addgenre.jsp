<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
					<li class="active"><a href="/admin/book">Books</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/genre">Genre</a></li>
					<li><a href="/admin/author">Authors</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/lang">Languages</a></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
					<li><a href="/admin/shop">Shop</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="col-md-12 col-xs-12 text-center"><h3>${book.title}</h3></div>
		<div class="row"><h4>Already added:</h4></div>
		<c:forEach items="${book.genre}" var="genre">
			<div class="row">
				<div class="col-md-6 col-xs-6">${genre.nameOfG}</div>
				<div class="col-md-6 col-xs-6"><a class="btn btn-danger" href="/admin/booky/delete/genre/${book.id}/${genre.id}">Remove</a></div>
			</div>
		</c:forEach>
		<div class="row"><h4>Can add:</h4></div>
		<c:forEach items="${genre}" var="genre">
			<div class="row">
				<div class="col-md-6 col-xs-6">${genre.nameOfG}</div>
				<div class="col-md-6 col-xs-6"><a class="btn btn-success" href="/admin/book/add/genre/${book.id}/${genre.id}">Add</a></div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>