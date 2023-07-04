<%@page import="be04.service.BookService"%>
<%@page import="be04.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Book list</title>
</head>
<body>
	Welcome to book list
	<hr>
	<nav class="book-menu">
		<ul>
			<c:forEach var="book" items="${booklist}">
				<li>${book.name} - ${book.id}</li>
			</c:forEach>
		</ul>
	</nav>
</body>
</html>