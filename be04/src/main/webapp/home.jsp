<%@page import="be04.entity.Category"%>
<%@page import="be04.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>En|Project</title>
<style>
* {
	box-sizing: border-box;
}

.sub-body-category {
	float: left;
	width: 50%;
	padding: 10px;
	height: 300px;
}

.sub-body-product {
	float: left;
	width: 50%;
	padding: 10px;
	height: 300px;
}

.body:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body>
	<div class="header">
		<form action="home">
			<input type="text" name="searchText" value="${searchText}"> <input type="submit"
				value="Search">
		</form>
	</div>
	<hr>
	
	<div class="body">
		<div class="sub-body-category">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		
		<div class="sub-body-product">
			<ul>
				<c:forEach var="book" items="${bookList}">
					<a href="home?searchName=${searchText}">
						<li>${book.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
	</div>
	<hr>
	
	<div class="footer">This is coding mentor BE04</div>

</body>
</html>