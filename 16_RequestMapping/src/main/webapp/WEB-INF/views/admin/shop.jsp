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
					<li><a href="/admin/lang">Languages</a></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
					<li class="active"><a href="/admin/shop">Shop</a><span
					class="sr-only">(current)</span></li>
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
				<form class="form-horizontal" action="/admin/shop" method="POST">
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Title of book</label>
    					<div class="col-sm-7">
      						<select class="form-control" name="bookId" id="bookId">
      							<c:forEach items="${books}" var="book">
      								<option value="${book.id}">${book.title}</option>
      							</c:forEach>
      						</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-7">
      						<select class="form-control" name="catId" id="catId">
      							<c:forEach items="${categories}" var="category">
      								<option value="${category.id}">${category.nameOfC}</option>
      							</c:forEach>
      						</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Language</label>
    					<div class="col-sm-7">
      						<select class="form-control" name="langId" id="langId">
      							<c:forEach items="${langM}" var="language">
      								<option value="${language.id}">${language.lang}</option>
      							</c:forEach>
      						</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Seria of publish</label>
    					<div class="col-sm-7">
      						<select class="form-control" name="seriaPubId" id="seriaPubId">
      							<c:forEach items="${series}" var="seriaPub">
      								<option value="${seriaPub.id}">${seriaPub.nameOfS}</option>
      							</c:forEach>
      						</select>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="nameOfS" class="col-sm-2 control-label">ISBN</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="isbn" id="isbn">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="nameOfS" class="col-sm-2 control-label">Year of publish</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="yearOfPub" id="yearOfPub">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="nameOfS" class="col-sm-2 control-label">Edition</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="edition" id="edition">
    					</div>
  					</div>
					<div class="form-group">
    					<label for="nameOfS" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="price" id="price">
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
			<div class="col-md-2 col-xs-2"><h3>Ttile</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Name of Publisher</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Year of first pub</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Year of pub</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Price</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Update</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${shops}" var="shop">
				<div class="row">
					<div class="col-md-2 col-xs-2">${shop.shbook.title}</div>
					<div class="col-md-2 col-xs-2">${shop.shSeria.publisher.name}</div>
					<div class="col-md-2 col-xs-2">${shop.shbook.frirstpub}</div>
					<div class="col-md-2 col-xs-2">${shop.shyear}</div>
					<div class="col-md-2 col-xs-2">${shop.shprice}</div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning btn-xs" href="/admin/shop/update/${shop.id}">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger btn-xs" href="/admin/shop/delete/${shop.id}">delete</a></div>
				</div>
				<div class="col-md-12 col-xs-12"></div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>