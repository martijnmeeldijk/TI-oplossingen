<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/sample.css">
    <meta charset="UTF-8">
    <title>Verwijder een student</title>
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
        <h2>Verwijder deze student</h2>

        <p>Ben je zeker dat je de student VOORNAAM NAAM wil verwijderen?</p>
        <form action="" method="">
            <input type="submit" value="Zeker">
            <input type="submit" value="Toch niet">
        </form>
    </article>
</main>
</body>
</html>