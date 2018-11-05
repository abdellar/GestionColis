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
import java.io.PrintWriter;

/**
 * Servlet utilisee pour enregistrer un colis par un utilisateur
 */
@WebServlet(value = "/Enregistrement", name = "Enregistrement")
public class EnregistrementColisServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @EJB
  private ColisOperation ejb;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public EnregistrementColisServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/enregistrement.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    long poids = Long.parseLong(request.getParameter("poids"));
    long valeur = Long.parseLong(request.getParameter("valeur"));
    String origine = request.getParameter("origine");
    String destination = request.getParameter("destination");
    Colis colis = ejb.creeColis(poids,valeur,origine,destination);
    PrintWriter out = response.getWriter();
    out.println( "<html><head></head><body><br><p> Colis crée : " + colis.toString() +"</p><br/><a href=\"index.jsp\">back</a></body></html>");
  }

}
