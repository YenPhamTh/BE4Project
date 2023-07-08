<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Detail</title>
<style>
* {
	box-sizing: border-box;
}

.body:after {
	content: "";
	display: table;
	clear: both;
}

.sub-header-left {
	float: left;
	width: 70%;
	padding: 10px;
	height: 50px;
}

.sub-header-right {
	float: left;
	width: 20%;
	padding: 10px;
	height: 50px;
}

.sub-header-cart {
	float: right;
	width: 10%;
	padding: 10px;
	height: 50px;
}

.header:after {
	content: "";
	display: table;
	clear: both;
}

.sub-body-product {
	float: left;
	width: 100%;
	padding: 10px;
	height: 300px;
}

.add-to-cart {
	float: left;
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
	opacity: 0.9;
}
</style>

</head>
<body>
	<div class="header">
		<div class="sub-header-left">
			<form action="home">
				<input type="text" name="searchText" value="${searchText}">
				<input type="submit" value="Search">
			</form>
		</div>
		<div class="sub-header-right">
			<a href="register.jsp" target="blank">Registration</a> || <a
				href="login.jsp" target="blank">Login</a> <br>
			${welcomeMessage}
		</div>
		<div class="sub-header-cart">
			<a href="cart?command=VIEW_CART">Shopping cart(${empty sessionScope.cart? 0 : sessionScope.cart.size()})</a>
		</div>
	</div>
	<hr>

	<div class="sub-body-product">
		<ul>
			<h1>Book detail</h1>
				<li>${book.name}</li>
				<li>${book.id}</li>
				<li>${book.categoryId}</li>
			</a>
		</ul>
	</div>
	<hr>
	<input type="button" class="add-to-cart" value="Add to cart"
	onclick="window.location.href='cart?command=ADD_TO_CART&bookId=${book.id}'" />
</body>
</html>