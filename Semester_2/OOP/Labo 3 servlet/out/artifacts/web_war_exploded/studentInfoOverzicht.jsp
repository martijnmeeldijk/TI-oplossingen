<%@ page import="domain.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%
    Student greetje = new Student("Jongen", "Greetje", "Toegepaste Informatica", 23);
    Student kristien = new Student("Melaerts", "Kristien", "Chemie", 21);
    Student elke = new Student("Steegmans", "Elke", "Vroedkunde", 16);
    Student jan = new Student("Van Hee", "Jan", "Verpleegkunde", 18);

    ArrayList<Student> students = new ArrayList<Student>();
    students.add(greetje);
    students.add(kristien);
    students.add(elke);
    students.add(jan);

    String lijst = "";

    for(Student s : students){
        lijst += s.printSelf() + "\n";
    }

    String stout = "Kevin is niet lief";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info: Overzicht</title>
</head>
<body>
<pre><%= lijst%></pre>

<% for(int k = 0; k < 20; k++){
%>

<% for(int i = 0; i < 150; i++){
%>
<pre><%= stout%></pre>
<%stout = " " + stout;} %>

<% for(int j = 0; j < 150; j++){
%>
<pre><%= stout%></pre>
<%stout = stout.substring(1);} %>

<%} %>
</body>
</html>
