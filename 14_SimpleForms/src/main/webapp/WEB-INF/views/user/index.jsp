<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Welcome!!!</h1>
<ul>
<c:forEach items="${categories}" var="category">
	<li><a href="/category/${category.id}">${category.nameOfC}</a></li>
</c:forEach>
</ul>

<a href="/admin">Admin panel</a>

