
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="nl-be">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>MijnFlix</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://codepen.io/gymratpacks/pen/VKzBEp#0">
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
</head>

<body>
<div id="header">
    <header>

        <ul id="nav">
            <li id="logo" class="hoofd"><a href="index.jsp"><img src="images/mijnflix.png" height="30px" alt="logo"></a></li>

            <li class="hoofd" ><a href="index.jsp">Home</a></li>
            <li id="currentlink" class="hoofd"><a href="voegToe.jsp">Voeg toe</a></li>
            <li class="hoofd"><a href="overzicht.jsp">Overzicht</a></li>
        </ul>
    </header>
</div>
<main>
    <div id= "form-wrapper">
        <div id="form-content">
            <h1 id="contacteer-header">Voeg toe</h1>
            <form action="${pageContext.request.contextPath}/Servlet" method="post" >
                <label for="name">Naam:</label>
                <input type="text" id="name" name="user_name">

                <label for="afleveringen">Afleveringen:</label>
                <input id="afleveringen"name="afleveringen" max="1000" min="1" step="1" type="number"/>

                <label for="duur">Duur:</label>
                <input name="duur" id ="duur" max="200" min="1"  step="1" type="number"/>

                <Label for="rating">Rating</Label>
                <select name="rating" id="rating">
                    <option value="" disabled selected>Rating</option>
                    <option value="1">Zeer slecht</option>
                    <option value="2">Slecht</option>
                    <option value="3">Gemiddeld</option>
                    <option value="4">Goed</option>
                    <option value="5">Uitstekend</option>

                </select>

                <label for="submit">Voeg Toe:</label>
                <input type="submit" name="submit" id="submit" value="submit"/>
            </form>
        </div>
    </div>


</main>
</body>
</html>
