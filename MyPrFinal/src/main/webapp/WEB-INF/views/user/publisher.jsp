<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h2>${publisher.name}</h2>
     <ul>
     <c:forEach items="${serias}" var="seriaPub">
    	<li>${seriaPub.nameOfS}</li>
    </c:forEach>
    </ul>