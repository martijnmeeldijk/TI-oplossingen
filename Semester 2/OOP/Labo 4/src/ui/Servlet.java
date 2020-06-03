package ui;


import model.db.SerieDB;
import model.domain.Serie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    SerieDB database = new SerieDB();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("database", database);

        request.getRequestDispatcher("overzicht.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naam = request.getParameter("naam");
        String afleveringen = request.getParameter("afleveringen");
        String duur = request.getParameter("duur");
        String rating = request.getParameter("rating");
        // boolean submitButtonPressed = request.getParameter("submit") != null;

        Serie nieuweSerie = new Serie(naam, Integer.parseInt(afleveringen), Integer.parseInt(duur), Integer.parseInt(rating));
        database.addSerie(nieuweSerie);
        request.setAttribute("data", database);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");

        view.forward(request, response);








    }










}