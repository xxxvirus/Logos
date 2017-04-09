<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <style type="text/css">
    .red{
    	color:red;
    }
    </style>
     <div class="red"><h2>${author.name} ${author.surname}</h2></div>
     <h2>Was born: ${author.yearOfBorn}</h2>
     <h2>Was dead: ${author.yearOfDead}</h2>
     <p><a href="${author.wiki}">Wiki</a></p>
     <hr>
    <h2>Author books: </h2> 
    <ul>
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
    </ul>