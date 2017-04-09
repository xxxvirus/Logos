<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<h2>Category</h2>
			<c:forEach items="${categories}" var="category">
				<div class="row">
					<a href="/category/${category.id}">${category.nameOfC}</a>
				</div>
			</c:forEach>
			<hr>
			<h2>Authors</h2>
			<c:forEach items="${authors}" var="author">
				<div class="row">
					<a href="/author/${author.id}">${author.name} ${author.surname}</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<form:form class="form-inline" action="/user/search/${category.nameOfC}"
						method="GET" modelAttribute="filterS">
						<custom:hiddenInputs excludeParams="search" />
						<div class="form-group">
							<form:input path="search" class="form-control"
								placeholder="Search" />
						</div>
						<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
</div>
<a href="/admin">Admin panel</a>

