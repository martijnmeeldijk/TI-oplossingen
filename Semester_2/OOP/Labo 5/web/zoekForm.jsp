<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Studenten</title>
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
		<h1>Zoek een student</h1>
		<form method="Get" action="StudentInfo" novalidate>
			<p>Wie zoek je?</p>
			<p class="form-group">
				<label class="control-label" for="naam">Naam: </label> <input
					id="naam" name="naam" type="text" value="" required>
			</p>
			<p class="form-group">
				<label class="control-label" for="voornaam">Voornaam: </label> <input
					id="voornaam" name="voornaam" type="text" value="">
			</p>

			<input type="hidden" id="command" name="command" value="zoek">

			<p>
				<label for="zoek">&nbsp;</label> <input id="zoek" type="submit"
					value="Vind Student">
			</p>

		</form>
	</article>
	</main>
</body>
</html>