package fr.usmb.m2isc.javaee.comptes.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries ({
	@NamedQuery(name="all", query="SELECT c FROM Compte c"),
	@NamedQuery(name="findWithNum", query="SELECT c FROM Compte c WHERE c.numero LIKE :partialNum ORDER BY c.numero ASC")
})
@Entity
public class Compte implements Serializable {
	
	@Id
	private String numero;
	private double solde;
	
	public Compte() {
	}
	
	
	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}	
}
