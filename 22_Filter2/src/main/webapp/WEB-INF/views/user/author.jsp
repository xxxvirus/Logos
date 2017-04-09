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
}
</style>
<div class="container-fluid">
	<div>
		<h2>${author.name} ${author.surname}</h2>
	</div>
	<h2>Was born: ${author.yearOfBorn}</h2>
	<c:if test="${author.yearOfDead == 0}">
	</c:if>
	<c:if test="${author.yearOfDead != 0}">
		<h2>Was dead: ${author.yearOfDead}</h2>
	</c:if>

	<p>
		<a href="${author.wiki}">Wiki</a>
	</p>
	<hr>
	<c:if test="${empty shops}">
		<h3>books not found</h3>
	</c:if>
	<c:if test="${!empty shops}">
		<h2>Author books:</h2>
	<div class="row">

		<div class="col-md-3">
			<form:form class="form-horizontal filter" action="/user/author"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="_languageIds, _categoryIds, _publisherIds, languageIds, categoryIds, publisherIds, max, min" />
				<div class="form-group">
					<div class="col-sm-6">
						<form:input path="min" class="form-control" placeholder="Min" />
					</div>
					<div class="col-sm-6">
						<form:input path="max" class="form-control" placeholder="Max" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Languages</label>
					<div class="col-sm-12">
						<form:checkboxes items="${langM}" path="languageIds"
							itemLabel="lang" itemValue="id" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Categories</label>
					<div class="col-sm-12">
						<form:checkboxes items="${categories}" path="categoryIds"
							itemLabel="nameOfC" itemValue="id" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Publishers</label>
					<div class="col-sm-12">
						<form:checkboxes items="${publishers}" path="publisherIds"
							itemLabel="name" itemValue="id" />
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>

		<div class="col-md-9">
			<c:forEach items="${shops}" var="shop">
				<div class="col-md-3">
					<div class="row">
						<a href="/book/${shop.titleSh.id}">${shop.titleSh.namePub}</a>
						<div>Language: ${shop.shlang.lang }</div>
						<div>Year of publish: ${shop.shyear }</div>
						<div class="red">Price: ${shop.shprice }</div>
						<button type="button" class="btn btn-primary btn-xs">Buy</button>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</c:if>
	
</div>