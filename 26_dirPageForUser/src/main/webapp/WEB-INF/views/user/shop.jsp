<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link rel="stylesheet" href="../resources/css/book.css">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<div>
			<a rel="simplebox" href="/images/shop/${book.id}.jpg">
				<img src="/images/shop/${book.id}.jpg" class="posterShop"></a>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="col-md-9">
					<h2>${book.titleSh.namePub}</h2>
					<a href="/author/${book.titleSh.book.author.id}">${book.titleSh.book.author.name}
					${book.titleSh.book.author.surname}</a>
				</div>
				<div class="col-md-3">
					<div class="price"><h2>${book.shprice}</h2></div>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-7">
							<button type="submit" class="btn btn-success btn-block">Buy</button>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 table-responsive">
					<table class="table">
						<tr>
							<td class="textBlock">Publisher:</td>
							<td class="textBlockText">${book.shSeria.publisher.name}</td>
						</tr>
						<tr>
							<td class="textBlock">Seria:</td>
							<td class="textBlockText">${book.shSeria.nameOfS}</td>
						</tr>
						<tr>
							<td class="textBlock">Language:</td>
							<td class="textBlockText">${book.shlang.lang}</td>
						</tr>
						<tr>
							<td class="textBlock">Number of page:</td>
							<td class="textBlockText">${book.shpage}</td>
						</tr>
						<tr>
							<td class="textBlock">Year of publish:</td>
							<td class="textBlockText">${book.shyear}</td>
						</tr>
						<tr>
							<td class="textBlock">ISBN:</td>
							<td class="textBlockText">${book.isbn}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
	<div class="row">
		<div class="col-md-9">
			<h3>Annotation:</h3>
			<div>
				<p class="anotationText">${book.anotation}</p>
			</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-12">
			<h3>Other Author books</h3>
			<c:forEach items="${shops}" var="shop">
				<c:if test="${shop.titleSh.book.author.id==book.titleSh.book.author.id}">
					<c:if test="${shop.titleSh.id!=book.titleSh.id}">
						<div class="col-md-3">
							<div class="row">
								<div><a href="/shop/${shop.id}"><img src="/images/shop/${shop.id}.jpg" class="poster"></a></div>
								<a href="/shop/${shop.id}">${shop.titleSh.namePub}</a>
								<div>Language: ${shop.shlang.lang }</div>
								<div>Year of publish: ${shop.shyear }</div>
								<div class="red">Price: ${shop.shprice }</div>
								<button type="button" class="btn btn-primary btn-xs">Buy</button>
							</div>
						</div>
					</c:if>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>