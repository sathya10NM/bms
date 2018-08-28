package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.services.CartService;
import org.web.util.CKUtil;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out=response.getWriter())
		{
			String user = CKUtil.get((HttpServletRequest) request, "useremail");
			System.out.println("sdsds");
			String value=request.getParameter("id");
			System.out.println(value);
			int v=Integer.parseInt(value);
			System.out.println("sdsds");
			//String q=request.getParameter("Quantity");
			//int i=Integer.parseInt(q);
			//System.out.println("i"+ i);
			//System.out.println("v"+ v);
			//System.out.println("u="+ user);
			CartService screen=new CartService();
			boolean res= screen.insert(v,user);
			if(res ==true)
			{
				out.write("Inserted");
				
			}
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
