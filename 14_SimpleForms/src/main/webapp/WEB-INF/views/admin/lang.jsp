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
					<li><a href="/admin/books">Books</a></li>
					<li><a href="/admin/authors">Authors</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/lang">Languages</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
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
				<form class="form-horizontal" action="/admin/lang" method="POST">
					<div class="form-group">
    					<label for="lang" class="col-sm-2 control-label">Language</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="lang" id="lang">
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-7">
      						<button type="submit" class="btn btn-success btn-block">Create</button>
    					</div>
  					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Language</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${langM}" var="language">
				<div class="row">
					<div class="col-md-4 col-xs-4">${language.lang}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning btn-xs" href="/admin/lang/update/${language.id}">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger btn-xs" href="/admin/lang/delete/${language.id}">delete</a></div>
				</div>
				<div class="col-md-12 col-xs-12"></div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>