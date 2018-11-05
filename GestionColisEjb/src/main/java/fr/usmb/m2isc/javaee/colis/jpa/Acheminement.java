package fr.usmb.m2isc.javaee.colis.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Acheminement implements Serializable {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private int id_acheminement;
  private int latitude;
  private int longitude;
  private String emplacement;
  private Etat etat;
  private Date date;
  @ManyToOne
  @JoinColumn(nullable = false)
  private Colis colis;

  public Acheminement() {}
  public Acheminement(int latitude, int longitude, String emplacement, Etat etat, Date date, Colis colis) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.emplacement = emplacement;
    this.etat = etat;
    this.date = date;
    this.colis = colis;
  }
  public Acheminement(String emplacement, Etat etat, Date date, Colis colis) {
    this.emplacement = emplacement;
    this.etat = etat;
    this.date = date;
    this.colis = colis;
  }
  public int getId_acheminement() { return id_acheminement; }
  public void setId_acheminement(int id_acheminement) {this.id_acheminement = id_acheminement; }
  public int getLatitude() { return latitude; }
  public void setLatitude(int latitude) { this.latitude = latitude; }
  public int getLongitude() { return longitude; }
  public void setLongitude(int longitude) { this.longitude = longitude; }
  public String getEmplacement() { return emplacement; }
  public void setEmplacement(String emplacement) { this.emplacement = emplacement; }
  public Etat getEtat() { return etat; }
  public void setEtat(Etat etat) { this.etat = etat; }
  public Date getDate() { return date; }
  public void setDate(Date date) { this.date = date; }

}
