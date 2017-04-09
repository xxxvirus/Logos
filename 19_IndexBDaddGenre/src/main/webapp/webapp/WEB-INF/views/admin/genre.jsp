<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<li><a href="/admin/book">Books</a></li>
					<li><a href="/admin/titleSh">TitleShop</a></li>
					<li class="active"><a href="/admin/genre">Genre</a><span
						class="sr-only">(current)</span></li>
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
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/genre"
					method="POST" modelAttribute="genre">
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2 control-label" for="nameOfG"
							style="color: red; text-align: left;"><form:errors
								path="nameOfG" /></label>
					</div>
					<div class="form-group">
						<label for="genre" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="nameOfG"
								id="genre" />
						</div>
						</div>
  					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-7">
							<button type="submit" class="btn btn-success btn-block">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Genre name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Add book</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Update</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${genres}" var="genre">
				<div class="row">
					<div class="col-md-3 col-xs-3">${genre.nameOfG}</div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-success" href="/admin/genre/add/book/${genre.id}">Add</a></div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-warning" href="/admin/genre/update/${genre.id}">update</a></div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-danger" href="/admin/genre/delete/${genre.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>