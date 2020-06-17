<%@page import="domain.model.Student"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Overzicht Studenten</title>
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

	<main id="container">
	<article>
		<h2>Overzicht studenten</h2>
		<%
			Collection<Student> students = (Collection<Student>) request.getAttribute("studenten");
			if (students != null) {
		%>
		<table id="overview">
			<tr>
				<th>Naam</th>
				<th>Voornaam</th>
				<th class="getal">Leeftijd</th>
				<th>Studierichting</th>
			</tr>
			<%
				for (Student student : students) {
			%>
			<tr id="<%=student.getNaam()%>">
				<td><%=student.getNaam()%></td>
				<td><%=student.getVoornaam()%></td>
				<td class="getal"><%=student.getLeeftijd()%></td>
				<td><%=student.getStudierichting()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		<p>Er zijn nog geen studenten toegevoegd.</p>
		<%
			}
		%>

	</article>
	</main>
</body>
</html>