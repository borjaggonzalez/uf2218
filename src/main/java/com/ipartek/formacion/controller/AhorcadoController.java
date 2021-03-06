package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class AhorcadoController
 */
@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String OP_INICIAR = "0";
	public static final String OP_LETRA = "1";
	private static String palabra;
	private static char[] respuesta;
	private int vidas;
	private int aciertos;
	private int fallos;
	private int lacertadas=0;
	private boolean ganador = false;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AhorcadoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		if (op != null) {
		switch (op) {
		case OP_INICIAR:
			palabra = null;
			iniciar(request,response);
			break;
		case OP_LETRA:
			comprobar(request,response);
			break;

		default:
			break;
		}
		}
		
		request.getRequestDispatcher("ahorcado/index.jsp").forward(request, response);
	}

	
	private void iniciar(HttpServletRequest request, HttpServletResponse response) {
		palabra = request.getParameter("palabra").trim().toUpperCase();
		if(palabra.isEmpty()) {
			request.setAttribute("mensaje", new Alert("warning", "No has introducido una palabra"));
		}else {
			vidas = 6;
			aciertos=0;
			lacertadas=0;
			fallos=0;
			ganador=false;
		int tamano = palabra.length();
	
		 respuesta = new char[tamano];

		for (int i = 0; i < tamano; i++) {
			respuesta[i] = '_';
		}
		request.setAttribute("ganador", ganador);
		request.setAttribute("fallos", fallos);
		request.setAttribute("vidas", vidas);
		request.setAttribute("palabra", palabra);
		request.setAttribute("respuesta", respuesta);
		}
		
	}
	
	private void comprobar(HttpServletRequest request, HttpServletResponse response) {
		if(vidas>0 || ganador==true) {    
		int tamano = palabra.length();
	       aciertos=0;
	       String op = request.getParameter("letra").trim().toUpperCase();
	  
	       if(op.isEmpty() ) {
				request.setAttribute("mensaje", new Alert("warning", "No has introducido una letra"));
			}else {
		char letra = op.charAt(0);
	       for (int i = 0; i < tamano; i++) {
	    	   
	    	   if (letra == palabra.toUpperCase().charAt(i)) {
	    		   respuesta[i] = letra;
	    		   aciertos = aciertos+1;
	    	   }else {
	    		
	    	   }
	    		 
			}
	       
	       if(aciertos == 0) {
	    	   fallos = fallos+1;
	    	   vidas = vidas-1;
	       }else {
	    	   lacertadas = lacertadas +aciertos;
	    	   
	    	if(lacertadas==tamano) {
	    		ganador=true;
	    	}
	       }
		}
	       request.setAttribute("ganador",ganador);
	       request.setAttribute("fallos", fallos);
	       request.setAttribute("vidas", vidas);
	       request.setAttribute("palabra", palabra);
	       request.setAttribute("respuesta", respuesta);
	}
	}

}
