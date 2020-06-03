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

<form action="${pageContext.request.contextPath}/Occurrences" method="get" >
    <input name="letter" type="text" placeholder="Letter" />
    <input name="woord" type="text" placeholder="Woord" />


    <input type="submit" name="submit" value="submit"/>
    </form>
</body>
</html>
