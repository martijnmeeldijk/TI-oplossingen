<%@ page import="ui.Servlet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.domain.Serie" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  %>
<html lang="nl-be">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>MijnFlix</title>

  <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div id="header">
  <header>

    <ul id="nav">
      <li id="logo" class="hoofd"><a href="index.jsp"><img src="images/mijnflix.png" height="30px" alt="logo"></a></li>

      <li id="currentlink"><a href="index.jsp">Home</a></li>
      <li class="hoofd"><a href="voegToe.jsp">Voeg toe</a></li>
      <li class="hoofd"><a href="overzicht.jsp">Overzicht</a></li>
    </ul>
  </header>
  <main>
    <div id="indexBoth">
      <div id="indexLeft">
        <h1 class="series">Mijn Series</h1>
        <h2 class="series">Hier vind u mijn favoriete series</h2>
      </div>
      <div id="indexRight">
        <h2>Dit is Wittie</h2>
      </div>
    </div>

  </main>

</div>
</body>
</html>