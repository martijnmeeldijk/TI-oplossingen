<%@ page import="java.util.ArrayList" %>
<%@ page import="model.db.SerieDB" %>
<%@ page import="model.domain.Serie" %><%--
  Created by IntelliJ IDEA.
  User: martijn
  Date: 28/02/2019
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            <li class="hoofd" ><a href="index.jsp">Home</a></li>
            <li class="hoofd"><a href="voegToe.jsp">Voeg toe</a></li>
            <li id="currentlink" class="hoofd"><a href="/Servlet">Overzicht</a></li>
        </ul>
    </header>
</div>

<main>
    <!--
                <ul id="series">
                    <li>
                        <ul class="series-item">
                            <li class="serie-naam">Naam</li>
                            <li class="serie-aantal">Aantal Afleveringen</li>
                            <li class="serie-duur">Duur</li>
                            <li class="serie-rating">Rating</li>
                        </ul>
                    </li>
                    <li>
                        <ul class="series-item">
                            <li class="serie-naam">azemrjnamergj</li>
                            <li class="serie-aantal">azemjnazmkrj</li>
                            <li class="serie-duur">ezgfgnzemkrgjn</li>
                            <li class="serie-rating">aerkjnelkrgjnl</li>
                        </ul>
                    </li>
                </ul>
    -->
    <div class="tabel">
        <table>
            <thead>
            <tr>
                <th>Naam</th>
                <th>Aantal Afleveringen</th>
                <th>Duur aflevering</th>
                <th>Rating</th>
                <th>Wijzig</th>
            </tr>
            </thead>

            <tbody>

            <%SerieDB data = (SerieDB) request.getAttribute("database");
            ArrayList<Serie> series = data.getSerielijst();

            //SerieDB test = new SerieDB();
            for(Serie s : series){

            %>
            <tr>
                <td> <%=s.getNaam()%></td>
                <td><%=s.getAfleveringen()%></td>
                <td><%=s.getDuur()%></td>
                <td><%=s.getRating()%>/5</td>
                <td>Wijzig</td>

            </tr>
            <% }%>

            </tbody>

        </table>
    </div>


</main>
</body>
</html>
