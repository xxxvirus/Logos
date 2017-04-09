<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add_book" method="get">
<div><label>Enter title of book</label></div>
			<div><input name="title"size="40"></div>
			<div><label>Enter number of pages</label></div>
			<div><input name="numbPages"size="40"></div>
			<div><label>Enter author name</label></div>
			<div><input name="authorName"size="40"></div>
			<div><label>Enter author surname</label></div>
			<div><input name="authorSurname"size="40"></div>
			<button>save</button>
</form>
</body>
</html>