package com.nagarro.training.AdvancedJavaAssignment3.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.training.AdvancedJavaAssignment3.models.Products;
import com.nagarro.training.AdvancedJavaAssignment3.models.Constants;
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
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		Products product = new Products();
		
		FileInputStream fileInputStream = new FileInputStream(request.getParameter("image"));
        byte[] imagesize = new byte[fileInputStream.available()];        
		fileInputStream.read(imagesize);
		
		if ((imagesize.length / Constants.byteunit) <= 1 
				&& (Constants.dbImageLimit + (imagesize.length / Constants.byteunit)) <= 10) {
			
			product.setTitle(request.getParameter("title"));
			product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			product.setSize(Integer.parseInt(request.getParameter("size")));
			
			product.setImage(imagesize);
			System.out.println(imagesize.length);
			product.setUser((String) session.getValue("username"));

			ProductDao.saveProduct(product,imagesize.length);

			response.sendRedirect(request.getContextPath() + "/homepage");

			System.out.println(imagesize.length);
			
		} else {
			response.getWriter().print(
					"<html><body><h4 style='color:red;text-align:center;'>Image not uploaded! Use a smaller file.</h4></body></html>");
			request.getRequestDispatcher("ProductsHome.jsp").include(request, response);
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
