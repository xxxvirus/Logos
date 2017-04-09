<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="container-fluid">
	<c:forEach items="${page.content}" var="category">
		<div class="row">
					<a href="/category/${category.id}">${category.nameOfC}</a>
				</div>
	</c:forEach>
</div>