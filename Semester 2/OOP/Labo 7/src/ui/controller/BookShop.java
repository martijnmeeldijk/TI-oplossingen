package ui.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.model.Book;

/**
 * Servlet implementation class BookShop
 */
@WebServlet("/BookShop")
public class BookShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String destination = "";
		
		String title = request.getParameter("title");
		String priceString = request.getParameter("price");
		String numberString = request.getParameter("number");
		int amount = 0;
		
		if (title.isEmpty() || priceString.isEmpty() || numberString.isEmpty()) {
			request.setAttribute("message", "Vul alle velden in.");
			destination = "bookForm.jsp";
		}
		else {
			int price = Integer.parseInt(priceString);
			int number = Integer.parseInt(numberString);
			amount = price * number;
			request.setAttribute("amount", amount);
			request.setAttribute("book", new Book(title,price,number));
			destination = "result.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
