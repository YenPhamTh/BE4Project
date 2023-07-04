package be04.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be04.entity.Book;
import be04.entity.Category;
import be04.service.BookService;
import be04.service.CategoryService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String categoryId = request.getParameter("categoryId");
			String searchText = request.getParameter("searchText");

			CategoryService categoryService = new CategoryService();
			BookService bookService = new BookService();

			List<Category> categoryList = new ArrayList<Category>();
			List<Book> bookList = new ArrayList<Book>();
			categoryList = categoryService.getAllCategories();

			if (searchText != null) {
				bookList = bookService.getBooksBySearch(searchText);
			} else if (categoryId != null) {
				bookList = bookService.getBooksByCategory(Integer.parseInt(categoryId));
			} else {
				bookList = bookService.getAllBooks();	
			}
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("bookList", bookList);
			request.setAttribute("searchText", searchText);
			rd.forward(request, response);

		} catch (SQLException e) {
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