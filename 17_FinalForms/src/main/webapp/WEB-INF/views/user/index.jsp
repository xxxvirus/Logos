<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Welcome!!!</h1>
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
</div>
<a href="/admin">Admin panel</a>

