package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.services.*;

/**
 * Servlet implementation class AddressServ
 */
@WebServlet("/AddressServ")
public class AddressServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("email");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String street = request.getParameter("street");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String zip=request.getParameter("zip");
			String state=request.getParameter("state");
			String country=request.getParameter("country");
			System.out.println(email+firstname+lastname+phone);
			AddressService add=new AddressService();
			add.create(email, firstname, lastname, address,phone, street, zip,state, country);
			
		
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
