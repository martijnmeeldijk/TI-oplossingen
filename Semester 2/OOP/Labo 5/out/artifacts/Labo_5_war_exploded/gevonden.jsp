<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.model.Student" %>
    
 <% Student student= (Student) request.getAttribute("student"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gevonden</title>
<link rel="stylesheet" href="css/sample.css">
</head>
<body>
<header>
	<div>
		<h1>Studentenregistratie</h1>
		<nav>
		<ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="zoekForm.jsp">Zoek een student</a></li>
            <li><a href="studentForm.jsp">Voeg een student toe</a></li>
            <li><a href="StudentInfo?command=overview">Bekijk alle studenten</a></li>
		</ul>
		</nav>
		</div>
				<img alt="Toscane" src="images/student.jpg">
		
</header>
<main>
<p id="boodschap">Je vroeg naar volgende gegevens: <%= student.format() %></p>
</main>

</body>
</html>