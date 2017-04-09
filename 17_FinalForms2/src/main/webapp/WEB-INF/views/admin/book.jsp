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
					<li class="active"><a href="/admin/books">Books</a><span
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
				<form class="form-horizontal" action="/admin/book" method="POST">
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Author</label>
    					<div class="col-sm-7">
      						<select class="form-control" name="authorId" id="authorId">
      							<c:forEach items="${authors}" var="author">
      								<option value="${author.id}">${author.name} ${author.surname}</option>
      							</c:forEach>
      						</select>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="title" class="col-sm-2 control-label">Title</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="title" id="title">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="pages" class="col-sm-2 control-label">Pages</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="pages" id="pages">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="pages" class="col-sm-2 control-label">Year of first Pub</label>
    					<div class="col-sm-7">
      						<input type="text" class="form-control" name="frirstpub" id="frirstpub">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Genre</label>
    					<div class="col-sm-7">
      						<select class="form-control" name="genre" id="genreId">
      							<c:forEach items="${genres}" var="genre">
      								<option value="${genre.id}">${genre.nameOfG}</option>
      							</c:forEach>
      						</select>
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
			<div class="col-md-2 col-xs-2"><h3>Book title</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Book pages</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Year of First Pub</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Author</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Update</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
		</div>
<!-- 		спеціальний тег для роботи з всім що можна прогорнути -->
<!-- 		а точніше з тим що імплементує Iterator<T> -->
<!-- 		items -- це посилання на колекцію, ім'я потрібно  -->
<!-- 		вказувати те яке ви передали в метод addAttribute  -->
<!-- 		першим параметром -->
<!-- 		var -- це назва одного елемента колекції -->
<!-- 		доступна лише в середині парного тегу c:forEach -->
			<c:forEach items="${books}" var="book">
				<div class="row">
<!-- 					тут все так само як на сервлетах -->
					<div class="col-md-2 col-xs-2">${book.title}</div>
					<div class="col-md-2 col-xs-2">${book.pages}</div>
					<div class="col-md-2 col-xs-2">${book.firstpub}</div>
					<div class="col-md-2 col-xs-2">${book.author.name} ${books.author.surname}</div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning btn-xs" href="/admin/book/update/${book.id}">update</a></div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-danger btn-xs" href="/admin/book/delete/${book.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>