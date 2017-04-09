<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/order" method="POST">
	<div class="form-group">
		<label for="address" class="col-md-2 control-label">Enter
			address:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="address">
		</div>
	</div>
	<div class="form-group">
		<label for="status" class="col-md-2 control-label">Enter
			status:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="status">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available orders:</h3>
<ul>
	<c:forEach items="${orders}" var="order">
		<li>${order.user.email}<a
			href="/admin/order/delete/${order.id}"> Delete</a>
		</li>
	</c:forEach>
</ul>