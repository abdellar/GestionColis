package fr.usmb.m2isc.javaee.colis.web;

import fr.usmb.m2isc.javaee.colis.ejb.ColisOperation;
import fr.usmb.m2isc.javaee.colis.jpa.Acheminement;
import fr.usmb.m2isc.javaee.colis.jpa.Colis;
import fr.usmb.m2isc.javaee.colis.jpa.Etat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Servlet utilisee pour changer les coordonnées du colis à chaque étape ;
 */
@WebServlet(value = "/Progression", name = "Progression")
public class ProgressionServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @EJB
  private ColisOperation ejb;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ProgressionServlet() {super();}

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Colis colis;
    List<Acheminement> listAcheminement;
    if (request.getParameter("unique_id") == null){
      colis = null;
      request.setAttribute("colis", colis);
      request.getRequestDispatcher("/progression.jsp").forward(request, response);
    } else{
      try {
        int unique_id = Integer.parseInt(request.getParameter("unique_id"));
        colis = ejb.getColis(unique_id);
        listAcheminement = colis.getAcheminements();
        request.setAttribute("colis", colis);
        request.setAttribute("listAcheminement", listAcheminement);
        request.setAttribute("etats", Etat.values());
        request.getRequestDispatcher("/progression.jsp").forward(request, response);
      } catch (NullPointerException e){
        e.printStackTrace();
        request.getRequestDispatcher("/progression.jsp").forward(request, response);
      } catch (NumberFormatException e){
        e.printStackTrace();
        request.getRequestDispatcher("/progression.jsp").forward(request, response);
      }
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Colis colis;
    Acheminement acheminement;
    int unique_id = Integer.parseInt(request.getParameter("unique_id"));
    String emplacement = request.getParameter("emplacement");
    Etat etat = Etat.getEtatString(request.getParameter("etat"));
    colis = ejb.getColis(unique_id);
    acheminement = ejb.creeAcheminement(0,0,emplacement,etat, Calendar.getInstance().getTime(),colis);
    ejb.addAcheminement(colis,acheminement);
    doGet(request,response);
  }
}
