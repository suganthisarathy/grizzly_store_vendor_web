package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Vendor;
import com.pack.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        int id=Integer.parseInt(request.getParameter("userid"));
        String password=request.getParameter("password");
        Vendor a=new Vendor(id,password);
        boolean val=new LoginServiceImpl().checkLogin(a);
        if(val)
        {
               pw.println("Login Succesfull");
               int i=new LoginServiceImpl().getCount(a);
               pw.println(i);
               if(i==3)
               {
                     pw.println("Attempt locked!!!");
               }
               else
               {
                     int j=new LoginServiceImpl().setZeroCount(a);
                     pw.println("setzerocount"+j);
               }
               String username=new LoginServiceImpl().getUsername(a);
               String contact=new LoginServiceImpl().getContact(a);
               String address=new LoginServiceImpl().getAddress(a);
               float rating=new LoginServiceImpl().getRating(a);
               a.setUsername(username);
               a.setContact(contact);
               a.setAddress(address);
               a.setRating(rating);
               HttpSession hs=request.getSession();
               hs.setAttribute("admin", a);
               hs.setAttribute("username", a.getUsername());
               hs.setAttribute("rating", a.getRating());
               hs.setAttribute("contact", a.getContact());
               hs.setAttribute("address", a.getAddress());
               RequestDispatcher rd=request.getRequestDispatcher("/ListProduct.jsp");
               rd.forward(request, response);
        }
        else
        {
               int i=new LoginServiceImpl().getCount(a);
               if(i==3)
               {
                     pw.println("attempt locked!!!");
               }
               else
               {
                     int j=new LoginServiceImpl().incrementCount(a,i);
                     RequestDispatcher rd=request.getRequestDispatcher("/index.html");
                     rd.forward(request, response);
               }
        }
        pw.close();
 }


}