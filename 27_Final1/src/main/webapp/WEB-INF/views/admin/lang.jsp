<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
	<div class="row">
		<nav class="navbar navbar-default">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/book">Books</a></li>
					<li><a href="/admin/titleSh">TitleShop</a></li>
					<li><a href="/admin/genre">Genres</a></li>
					<li><a href="/admin/author">Authors</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/lang<custom:allParams/>">Languages</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
					<li><a href="/admin/shop">Shop</a></li>
					<li><a href="/admin/order">Orders</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="row">
		<div class="col-md-3 col-xs-12">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<form:form class="form-inline" action="/admin/lang"
						method="GET" modelAttribute="filter">
						<custom:hiddenInputs excludeParams="search" />
						<div class="form-group">
							<form:input path="search" class="form-control"
								placeholder="Search" />
						</div>
						<button type="submit" class="btn btn-primary">Ok</button>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-md-7 col-xs-12">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<form:form class="form-horizontal" action="/admin/lang"
						method="POST" modelAttribute="lang">
						<div class="form-group">
							<label class="col-sm-7 col-sm-offset-2 control-label" for="lang"
								style="color: red; text-align: left;"><form:errors
									path="lang" /></label>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Language</label>
							<div class="col-sm-7">
								<form:input class="form-control" path="lang" id="lang" />
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
				<div class="col-md-4 col-xs-4">
					<h3>Language</h3>
				</div>
				<div class="col-md-4 col-xs-4">
					<h3>Update</h3>
				</div>
				<div class="col-md-4 col-xs-4">
					<h3>Delete</h3>
				</div>
			</div>
			<c:forEach items="${page.content}" var="language">
				<div class="row">
					<div class="col-md-4 col-xs-4">${language.lang}</div>
					<div class="col-md-4 col-xs-4">
						<a class="btn btn-warning btn-xs"
							href="/admin/lang/update/${language.id}<custom:allParams/>">update</a>
					</div>
					<div class="col-md-4 col-xs-4">
						<a class="btn btn-danger btn-xs"
							href="/admin/lang/delete/${language.id}<custom:allParams/>">delete</a>
					</div>
				</div>
				<div class="col-md-12 col-xs-12"></div>
			</c:forEach>
		</div>
		<div class="col-md-2 col-xs-12">
			<div class="row">
				<div class="col-md-6 col-xs-6">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Lang asc" paramValue="lang" />
							<custom:sort innerHtml="Lang desc" paramValue="lang,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-6 col-xs-6">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>
