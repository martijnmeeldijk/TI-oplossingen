<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Voeg een student toe</title>
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
		<h2>Voeg een student toe</h2>
		<form method="POST" action="StudentInfo" novalidate>
			<fieldset>
				<legend>Student informatie</legend>
				<p class="form-group">
					<label class="control-label" for="name">Naam: </label> <input
						id="naam" name="naam" type="text" value="" required>
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Voornaam: </label> <input
						id="voornaam" name="voornaam" type="text" value="">
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Leeftijd: </label> <input
						id="leeftijd" name="leeftijd" type="text" value="">
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Studierichting: </label> <input
						id="studierichting" name="studierichting" type="text" value="">
				</p>
			</fieldset>
			<p>
				<label for="bewaar">&nbsp;</label> <input id="bewaar" type="submit"
					value="Voeg Student Toe">
			</p>

		</form>
	</article>
	</main>
</body>
</html>