package ui.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Occurrences")
public class Occurrences extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String woord = request.getParameter("woord");
        String letter = request.getParameter("letter");

        int aantal = woord.length() - woord.replace(letter, "").length();
        String count = Integer.toString(aantal);

        request.setAttribute("antwoord", count);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}
