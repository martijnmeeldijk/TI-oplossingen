<%@ page import="java.util.ArrayList" %>
<%

%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
    <title>Occurrences</title>
</head>
<body>

<img src="images/sad.jpg" height="50px">
<% String result = request.getAttribute("antwoord").toString(); %>
<p id="antwoord">Het antwoord is: <%=result%></p>
</body>
</html>
