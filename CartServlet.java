package be04.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be04.entity.Book;
import be04.service.BookService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String command = request.getParameter("command");
			int bookId = 0;
		try {
			if(command != null & command.equals("ADD_TO_CART")){
				bookId = Integer.parseInt(request.getParameter("bookId"));
				Book book = new BookService().getBookById(bookId);
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");
				
				if (cart == null) {
					cart = new HashMap<Integer, Book>();
				}
				cart.put(book.getId(),book);
				session.setAttribute("cart",cart);
				request.setAttribute("book", book);
				//go back to prev. page
				response.sendRedirect("detail?command=DETAIL&bookId="+bookId);
			} else if(command !=null && command.equals("VIEW CART")){
				response.sendRedirect("cart.jsp");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
