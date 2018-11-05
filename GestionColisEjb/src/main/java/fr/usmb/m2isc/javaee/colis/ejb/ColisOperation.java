package fr.usmb.m2isc.javaee.colis.ejb;

import fr.usmb.m2isc.javaee.colis.jpa.Colis;

import java.util.List;

public interface Operation {

	Colis creerColis(double poids, double valeur, String origine, String destination);

	Colis getColis(int id);

	List<Colis> getAllColis();

	void updateColis(Colis colis);

	void suivreColis(Colis colis);

}