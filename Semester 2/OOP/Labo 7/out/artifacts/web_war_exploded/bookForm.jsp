<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css" type="text/css">
<title>Book Info</title>
</head>
<body>
	<h2>Book info</h2>
	<% if (request.getAttribute("message")!=null) { %>
	<p><%= request.getAttribute("message") %>
	</p>
	<% } %>
	<form method="GET" action="BookShop" novalidate>
			<p>
				<label for="title">Titel: </label> <input id="title" name="title">
			</p>
			<p>
				<label for="price">Prijs (required): </label> <input id="price"
					name="price" type="number" required>
			</p>
			<p>
				<label for="number">Aantal boeken (required): </label> <input id="number"
					name="number"  type="number" required>
			</p>
		<p>
			<input id="calculate" type="submit" value="Bereken">
		</p>
	</form>
</body>
</html>