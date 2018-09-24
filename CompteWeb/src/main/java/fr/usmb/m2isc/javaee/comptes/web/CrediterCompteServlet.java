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
 * Servlet utilisee pour crediter un compte.
 */
@WebServlet("/CrediterCompteServlet")
public class CrediterCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrediterCompteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("numero");
		String val = request.getParameter("depot");
		double depot = Double.parseDouble(val);
		
		Compte cpt = ejb.crediter(num, depot);	
		request.setAttribute("compte", cpt);
		request.getRequestDispatcher("/AfficherCompte.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
