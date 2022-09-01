package com.nagarro.training.AdvancedJavaAssignment3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.training.AdvancedJavaAssignment3.models.Products;
import com.nagarro.training.AdvancedJavaAssignment3.utility.ProductDao;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
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

		HttpSession session = request.getSession(true);
		
		Products product = new Products();
		
		product.setTitle(request.getParameter("title"));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setSize(Integer.parseInt(request.getParameter("size")));
		product.setImage(request.getParameter("image"));
		product.setUser((String) session.getValue("username"));
		
		ProductDao.saveProduct(product);
		
		response.sendRedirect(request.getContextPath()+"/homepage");

	}

}
