<%@ page import="domain.model.Book"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
	
<!DOCTYPE html>
<html>
<head>
	<title>Book</title>
	<link rel="stylesheet" href="css/sample.css" type="text/css">
</head>
<body>
	<h1>Book</h1>
	<% Book book = (Book) request.getAttribute("book"); %>
	<p> Voor <%= book.getNumber() %> exemplaren van het boek <span id="title"><%= book.getTitle() %></span> moet je
	&euro;<span id="amount"><%= request.getAttribute("amount") %></span> betalen.</p> 
	<p style="text-align: center"><img src="img/book.jpg" alt="Boek: alles komt goed"></p>
</body>
</html>