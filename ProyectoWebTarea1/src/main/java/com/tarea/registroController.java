package com.tarea;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registroController
 */
public class registroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registroController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		//verificar usuario en cookies
		String usuario = "";
		Cookie[] galletitas = request.getCookies();
		if(galletitas !=null) {
			for(Cookie galleta: galletitas)
				if(galleta.getName().equals("id")){
					usuario = galleta.getValue();
					out.append("<br/><br/><center><h1>Ya est&aacute; registrado: "+usuario+"</h1></center>");
				}else {
						out.append("<br/><br/><center><h3>P&aacute;gina en construcci&oacute;n");
				}
		}else {
			out.append("<br/><br/><center><h3>P&aacute;gina en construcci&oacute;n...");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
