package fr.usmb.m2isc.javaee.colis.web;

import fr.usmb.m2isc.javaee.colis.jpa.Colis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet utilisee pour changer les coordonnées du colis à chaque étape ;
 */
@WebServlet(value = "/Progression", name = "Progression")
public class ProgressionServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ProgressionServlet() {super();}

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/progression.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
