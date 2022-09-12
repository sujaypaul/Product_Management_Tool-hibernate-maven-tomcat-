package com.nagarro.training.AdvancedJavaAssignment3.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import com.nagarro.training.AdvancedJavaAssignment3.models.Constants;
import com.nagarro.training.AdvancedJavaAssignment3.models.Products;
import com.nagarro.training.AdvancedJavaAssignment3.utility.ProductDao;

/**
 * Servlet implementation class UpdateProduct
 */
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProduct() {
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

		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		String user = (String) session.getValue("username");

		FileInputStream fileInputStream = new FileInputStream(request.getParameter("image"));
		byte[] imagesize = new byte[fileInputStream.available()];
		fileInputStream.read(imagesize);

		if ((imagesize.length / Constants.byteunit) <= 1
				&& (Constants.dbImageLimit + (imagesize.length / Constants.byteunit)) <= 10) {

			int id = (int) session.getAttribute("id");
			Products product = ProductDao.getProduct(id);
			
			Constants.dbImageLimit -= (product.getImage().length / Constants.byteunit);
			System.out.println("database after running delete = "+Constants.dbImageLimit);

			product.setTitle(request.getParameter("title"));
			product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			product.setSize(Integer.parseInt(request.getParameter("size")));

			product.setImage(imagesize);
			System.out.println(imagesize.length);
			product.setUser((String) session.getValue("username"));

			ProductDao.updateProduct(product,imagesize.length);

			response.sendRedirect(request.getContextPath() + "/homepage");

			System.out.println(imagesize.length);
			
			
			session.removeAttribute("title");
			session.removeAttribute("quantity");
			session.removeAttribute("size");
			session.removeAttribute("image");

		} else {
			response.getWriter().print(
					"<html><body><h4 style='color:red;text-align:center;'>Image not uploaded! Use a smaller file.</h4></body></html>");
			request.getRequestDispatcher("EditProduct.jsp").include(request, response);

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
