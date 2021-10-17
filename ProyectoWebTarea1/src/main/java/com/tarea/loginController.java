package com.tarea;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController
 */
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginController() {
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
		// Validación del usuario:
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		ServletConfig sConfig = getServletConfig();
		String usu = sConfig.getInitParameter("username");
		String pas = sConfig.getInitParameter("password");
		String usuf = request.getParameter("usuario");
		String pasf = request.getParameter("pass");
		
		if(usu.equals(usuf) && pas.equals(pasf)) {
			Cookie galletita = new Cookie("id",usuf);
			galletita.setMaxAge(60*2);//2 minutos
			response.addCookie(galletita);
			out.append("<br/><br/><center><h1>Bienvenido " + usu+"!</h1></center>");
		}else{
			out.append("<br/><center><h3>Usuario o password incorrectos!<br/>");
			out.append("<br/>No está loggeado..</h3></center>");
		}
		//doGet(request, response);
	}

}
