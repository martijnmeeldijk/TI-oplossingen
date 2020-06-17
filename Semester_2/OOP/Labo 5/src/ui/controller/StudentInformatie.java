package ui.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.StudentDB;
import domain.model.Student;

@WebServlet("/StudentInfo")
public class StudentInformatie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDB klas=new StudentDB();
       
    public StudentInformatie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        switch (command) {
            case ("zoek"):
                zoekStudent(request, response);
            break;
            case ("overview"):
                naarOverview(request, response);
                break;




        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String leeftijd = request.getParameter("leeftijd");
		String studierichting = request.getParameter("studierichting");
		
		String destination = "index.html";
		
		if (naam.isEmpty() || voornaam.isEmpty() || leeftijd.isEmpty() || studierichting.isEmpty()) {
			destination = "studentForm.jsp";
		}
		else {
			Student student = new Student(naam, voornaam, Integer.parseInt(leeftijd), studierichting);
			klas.voegToe(student);
			request.setAttribute("studenten", klas.getKlas());
			destination = "studentOverview.jsp";
		}
		
		request.getRequestDispatcher(destination).forward(request, response);
	}

	public void zoekStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naam=request.getParameter("naam");
        String voornaam=request.getParameter("voornaam");
        String destination="";

        if (naam==null || voornaam== null) {
            destination="nietGevonden.jsp";
        }
        else {
            Student student=klas.vind(naam, voornaam);
            if (student==null) {
                destination="nietGevonden.jsp";
            }
            else {
                destination="gevonden.jsp";
                request.setAttribute("student", student);
            }
        }
        RequestDispatcher view=request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    public void naarOverview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studenten", klas.getKlas());
        RequestDispatcher view=request.getRequestDispatcher("studentOverview.jsp");
        view.forward(request, response);
    }


}
