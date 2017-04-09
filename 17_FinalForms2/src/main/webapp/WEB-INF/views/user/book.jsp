<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h2>${book.title}</h2>
     <c:forEach items="${shops}" var="shop">
	 <div><h3>Author: </h3><a href="/author/${shop.shbook.author.id}">${shop.shbook.author.name} ${shop.shbook.author.surname}</a></div>
	 <div><h3>Publisher: </h3><a href="/publisher/${shop.shSeria.publisher.id}">${shop.shSeria.publisher.name}</a></div>
	 <div><h3>Seria of publishing: </h3>${shop.shSeria.nameOfS}</div>
	 <div><h3>Language: </h3>${shop.shlang.lang}</div>
	 <div><h3>Year of publish: </h3>${shop.shyear}</div>
	 <div><h3>Year of write: </h3>${shop.shbook.frirstpub}</div>
	 <div><h3>ISBN: </h3>${shop.isbn}</div>
	 <div><h3>Edition: </h3>${shop.edition}</div>
	 
	 </c:forEach>
