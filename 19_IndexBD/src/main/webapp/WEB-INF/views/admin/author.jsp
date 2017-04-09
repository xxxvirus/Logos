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
					<li class="active"><a href="/admin/author">Authors</a><span
						class="sr-only">(current)</span></li>
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
				<form:form class="form-horizontal" action="/admin/author" method="POST" modelAttribute="author">
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-7">
      						<form:input class="form-control" path="name" id="name"/>
    					</div>
    					<label class="col-sm-3 control-label" for="name" style="color:red;text-align:left;"><form:errors path="name"/></label>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Surname</label>
    					<div class="col-sm-7">
      						<form:input class="form-control" path="surname" id="surname"/>
    					</div>
    					<label class="col-sm-3 control-label" for="surname" style="color:red;text-align:left;"><form:errors path="surname"/></label>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Born</label>
    					<div class="col-sm-7">
      						<form:input class="form-control" path="yearOfBorn" id="yearOfBorn"/>
    					</div>
    					<label class="col-sm-3 control-label" for="yearOfBorn" style="color:red;text-align:left;"><form:errors path="yearOfBorn"/></label>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Dead</label>
    					<div class="col-sm-7">
      						<form:input class="form-control" path="yearOfDead" id="yearOfDead"/>
    					</div>
    					<label class="col-sm-3 control-label" for="yearOfDead" style="color:red;text-align:left;"><form:errors path="yearOfDead"/></label>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Wiki</label>
    					<div class="col-sm-7">
      						<form:input class="form-control" path="wiki" id="wiki"/>
    					</div>
    					<label class="col-sm-3 control-label" for="wiki" style="color:red;text-align:left;"><form:errors path="wiki"/></label>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-7">
      						<button type="submit" class="btn btn-success btn-block">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		</div>
		<div class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Authors name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Authors surname</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Born</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Dead</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Wiki</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Update</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${authors}" var="author">
				<div class="row">
					<div class="col-md-2 col-xs-2">${author.name}</div>
					<div class="col-md-2 col-xs-2">${author.surname}</div>
					<div class="col-md-2 col-xs-2">${author.yearOfBorn}</div>
					<div class="col-md-2 col-xs-2">${author.yearOfDead}</div>
					<div class="col-md-2 col-xs-2"><a href="${author.wiki}">Wiki</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning btn-xs" href="/admin/author/update/${author.id}">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger btn-xs" href="/admin/author/delete/${author.id}">delete</a></div>
				</div>
				<div class="col-md-12 col-xs-12"></div>
			</c:forEach>
	</div>
	</div>
	<div class="col-md-2 col-xs-12"></div>
