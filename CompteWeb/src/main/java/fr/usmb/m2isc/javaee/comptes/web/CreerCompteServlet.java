package fr.usmb.m2isc.javaee.comptes.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.comptes.ejb.Operation;
import fr.usmb.m2isc.javaee.comptes.jpa.Compte;

/**
 * Servlet utilisee pour creer un compte.
 */
@WebServlet("/CreerCompteServlet")
public class CreerCompteServlet extends HttpServlet{

	private static final long serialVersionUID = 5236668439173484090L;
	@EJB
	private Operation op;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	public CreerCompteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("numero");
		String val = request.getParameter("depot");
		double depot = Double.parseDouble(val);
		
		Compte cpt = op.creerCompte(num, depot);
		
		request.setAttribute("compte", cpt);

		//response.getWriter().println("C'est fait");

		request.getRequestDispatcher("/AfficherCompte.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
