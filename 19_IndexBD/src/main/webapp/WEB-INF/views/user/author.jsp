<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h2>${author.name} ${author.surname}</h2>
     <h2>Was born: ${author.yearOfBorn}</h2>
     <h2>Was dead: ${author.yearOfDead}</h2>
     <p><a href="${author.wiki}">Wiki</a></p>
     <hr>
    <h2>Author books: </h2> 
    <ul>
    <c:forEach items="${titleShops}" var="titleShop">
    	<li><a href="/book/${titleShop.id}">${titleShop.namePub}</a></li>
    </c:forEach>
    </ul>