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
 * Servlet implementation class EditProduct
 */
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("productId"));
		System.out.println(id);
		Products product = ProductDao.getProduct(id);
		
		HttpSession session = request.getSession(true);
		
		session.putValue("id", id);
		
		session.putValue("title", product.getTitle());
		session.putValue("quantity", product.getQuantity());
		session.putValue("size", product.getSize());
//		session.putValue("image", product.getImage());
		

		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		} else {
			@SuppressWarnings({ "deprecation", "unused" })
			String username = (String) session.getValue("username");
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		}
		



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
