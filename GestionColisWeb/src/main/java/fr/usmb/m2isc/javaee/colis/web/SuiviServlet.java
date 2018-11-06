package fr.usmb.m2isc.javaee.colis.web;

import fr.usmb.m2isc.javaee.colis.ejb.ColisOperation;
import fr.usmb.m2isc.javaee.colis.jpa.Colis;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/Suivi", name = "Suivi")
public class SuiviServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @EJB
  private ColisOperation ejb;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SuiviServlet() {super();}

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Colis> colis;
    colis = ejb.getAllColis();
    request.setAttribute("colisList", colis);
    request.getRequestDispatcher("/suivi.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
