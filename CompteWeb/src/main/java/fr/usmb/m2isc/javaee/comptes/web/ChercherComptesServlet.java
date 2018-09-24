package fr.usmb.m2isc.javaee.comptes.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.comptes.ejb.Operation;
import fr.usmb.m2isc.javaee.comptes.jpa.Compte;


/**
 * Servlet utilisee pour rechercher des comptes a partir d'un numero partiel.
 */
@WebServlet("/ChercherComptesServlet")
public class ChercherComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChercherComptesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partialNumber = request.getParameter("partialNumber");
		List<Compte> cpts ;
		if (partialNumber != null && partialNumber.length() > 0 ) {
			cpts = ejb.findComptes("%"+partialNumber+"%");
		} else {
			cpts = ejb.findAllComptes();
		}
		request.setAttribute("comptes", cpts);
		request.getRequestDispatcher("/AfficherComptes.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
