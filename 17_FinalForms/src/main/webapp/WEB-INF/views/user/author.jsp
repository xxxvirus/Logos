<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h2>Author name: ${author.name}</h2>
     <h2>Author surname: ${author.surname}</h2>
     <h2>Was born: ${author.yearOfBorn}</h2>
     <h2>Was dead: ${author.yearOfDead}</h2>
     <p><a href="${author.wiki}">Wiki</a></p>
     <hr>
    <h2>Author books: </h2> 
    <ul>
    <c:forEach items="${books}" var="book">
    	<li><a href="/book/${book.id}">${book.title}</a></li>
    </c:forEach>
    </ul>