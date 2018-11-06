package fr.usmb.m2isc.javaee.colis.ejb;

import fr.usmb.m2isc.javaee.colis.jpa.Acheminement;
import fr.usmb.m2isc.javaee.colis.jpa.Colis;
import fr.usmb.m2isc.javaee.colis.jpa.Etat;

import java.util.Date;
import java.util.List;

public interface ColisOperation {

	Colis creeColis(double poids, double valeur, String origine, String destination);

	Colis getColis(int unique_id);

	List<Colis> getAllColis();

	void updateColis(Colis colis);

	String suivreColis(Colis colis);

	Acheminement creeAcheminement(int latitude, int longitude, String emplacement, Etat etat, Date date, Colis colis);

	void addAcheminement(Colis colis,Acheminement acheminement);

}