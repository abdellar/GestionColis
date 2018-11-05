package fr.usmb.m2isc.javaee.colis.web;

import fr.usmb.m2isc.javaee.colis.ejb.ColisOperation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet utilisee pour transferer de l'argent d'un compte vers un autre compte.
 */
@WebServlet(value = "/home", name ="index" )
public class PageAccueilServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public PageAccueilServlet() {super();}

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // request.setAttribute("Colis", ejb.getAllColis());
    // System.out.println(ejb.getAllColis().toString());
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

}
