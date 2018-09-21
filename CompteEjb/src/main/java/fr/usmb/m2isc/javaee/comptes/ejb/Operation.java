package fr.usmb.m2isc.javaee.comptes.ejb;

import fr.usmb.m2isc.javaee.comptes.jpa.Compte;

public interface Operation {

	Compte creerCompte(String number, double depot);

	Compte getCompte(String number);

	Compte crediter(String number, double val);

	Compte debiter(String number, double val);

	void transferer(String numCpt1, double val, String numCpt2);

}