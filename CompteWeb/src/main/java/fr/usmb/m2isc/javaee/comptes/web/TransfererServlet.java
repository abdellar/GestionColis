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
 * Servlet utilisee pour transferer de l'argent d'un compte vers un autre compte.
 */
@WebServlet("/TransfererServlet")
public class TransfererServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransfererServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numCpt1 = request.getParameter("compte1");
		String numCpt2 = request.getParameter("compte2");
		String val = request.getParameter("somme");
		double somme = Double.parseDouble(val);
		
		ejb.transferer(numCpt1, somme, numCpt2);	
		List<Compte> cpts = new ArrayList<>();
		cpts.add(ejb.getCompte(numCpt1));
		cpts.add(ejb.getCompte(numCpt2));
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
