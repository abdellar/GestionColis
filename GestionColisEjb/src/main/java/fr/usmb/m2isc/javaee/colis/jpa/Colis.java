package fr.usmb.m2isc.javaee.colis.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name="all", query = "SELECT c FROM Colis c"),
})
@Entity
public class Colis implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int unique_id;
  private double poids;
  private double valeur;
  private String origine;
  private String destination;
  @OneToMany(
          targetEntity = Acheminement.class,
          cascade = CascadeType.ALL,
          fetch = FetchType.EAGER,
          mappedBy = "colis",
          orphanRemoval = true)
  private List<Acheminement> acheminements = new ArrayList();

  public Colis() {}

  public Colis(double poids, double valeur, String origine, String destination) {
    Date today = Calendar.getInstance().getTime();
    this.poids = poids;
    this.valeur = valeur;
    this.origine = origine;
    this.destination = destination;
    this.acheminements.add(new Acheminement(origine,Etat.enregistrement, today,this));
  }

  @Override
  public String toString() {
    return "Colis {" +
            " ID : " + unique_id + "\n" +
            " Date : " + acheminements.get(acheminements.size()-1).getDate().toString() + "\n" +
            " Emplacement : " + acheminements.get(acheminements.size()-1).getEmplacement().toString() + "\n" +
            " Status : " + acheminements.get(acheminements.size()-1).getEtat().toString() + "\n" +
            " Poids : " + poids + "\n" +
            " Valeur : " + valeur + "\n" +
            " Origine " + origine + "\n" +
            " Destination : " + destination ;
  }

  public int getUnique_id() { return unique_id; }

  public void setUnique_id(int unique_id) { this.unique_id = unique_id; }

  public double getPoids() { return poids; }

  public void setPoids(double poids) { this.poids = poids; }

  public double getValeur() { return valeur; }

  public void setValeur(double valeur) { this.valeur = valeur; }

  public String getOrigine() { return origine; }

  public void setOrigine(String origine) { this.origine = origine; }

  public String getDestination() { return destination; }

  public void setDestination(String destination) { this.destination = destination; }

  public List<Acheminement> getAcheminements() { return acheminements; }

  public void setAcheminements(List<Acheminement> acheminements) { this.acheminements = acheminements; }
}
