package fr.usmb.m2isc.javaee.colis.jpa;

public enum Etat {
  enregistrement("Enregistrement"),
  en_attente("En attente"),
  en_acheminement("En acheminement"),
  bloque("Bloqué"),
  en_cours_de_livraison("En cours de livraison");

  private String etat;

  Etat(String etat){
    this.etat = etat;
  }

  @Override
  public String toString(){
    return etat;
  }

  public String getEtat() {
    return etat;
  }

  public static Etat getEtatString(String etatS){
    for (Etat e : Etat.values()){
      if (e.getEtat().equals(etatS)){
        return e;
      }
    }
    return null;
  }
}
