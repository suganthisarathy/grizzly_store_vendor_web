package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.dao.AddProductDaoImpl;
import com.pack.model.AddProduct;
import com.pack.model.vendors;
import com.pack.service.AddProductServiceImpl;

/**
 * Servlet implementation class QuantityUpdateController
 */
@WebServlet("/QuantityUpdateController")
public class QuantityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuantityUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("productid"));
		int quan=Integer.parseInt(request.getParameter("quantity"));
		System.out.println(id);
		System.out.println(quan);
		int i=new AddProductServiceImpl().updateQuantity(quan,id);
		if(i==1)
		{
			List<vendors> l=null;
		    l=new AddProductServiceImpl().listVendors();
			request.setAttribute("custlist",l);
			RequestDispatcher rd=request.getRequestDispatcher("/ListVendors.jsp");
			rd.forward(request, response);
		}
		
	}

}
