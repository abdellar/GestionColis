package fr.usmb.m2isc.javaee.comptes.ejb;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.usmb.m2isc.javaee.comptes.jpa.Compte;

@Stateless
@Remote
public class OperationBean implements Operation {
	
	@PersistenceContext
	private EntityManager em;
	
	public OperationBean() {
	}
	
	@Override
	public Compte creerCompte(String number, double depot) {
		Compte cpt = new Compte(number, depot);
		em.persist(cpt);
		return cpt;
	}
	
	@Override
	public Compte getCompte(String number) {
		return em.find(Compte.class, number);
	}

	@Override
	public Compte crediter(String number, double val) {
		Compte cpt = em.find(Compte.class, number);
		cpt.setSolde(cpt.getSolde() + val);
		if (val < 0 ) throw new EJBException("depot negatif");
		return cpt;
	}

	@Override
	public Compte debiter(String number, double val) {
		Compte cpt = em.find(Compte.class, number);
		cpt.setSolde(cpt.getSolde() - val);
		if (val < 0 ) throw new EJBException("retrait negatif");
		return cpt;
	}

	@Override
	public void transferer(String numCpt1, double val, String numCpt2) {
		crediter(numCpt2, val);
		debiter(numCpt1, val);
		if (val < 0 ) throw new EJBException("retrait negatif");
	}
}
