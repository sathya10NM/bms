package org.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.web.services.ItemService;

/**
 * Servlet implementation class AddItem
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
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
			String itemName=request.getParameter("itemname");
			String itemId=request.getParameter("id");
			String price=request.getParameter("price");
			//String path=request.getParameter("url");
			System.out.println("screen");
			Part part=request.getPart("url"); 
			String location = getServletConfig().getInitParameter("storage");
			String proof = Servletutil.extract(part);
			part.write(location + File.separator + proof);
			ItemService itemservice=new ItemService();
			boolean res=itemservice.insert(itemId,itemName,price,proof);
			if(res==true)
			{
				response.sendRedirect("addmovie.html");
			
			}
			else
			{
				System.out.println("");
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