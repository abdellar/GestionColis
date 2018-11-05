package fr.usmb.m2isc.javaee.colis.ejb;

import fr.usmb.m2isc.javaee.colis.jpa.Acheminement;
import fr.usmb.m2isc.javaee.colis.jpa.Colis;
import fr.usmb.m2isc.javaee.colis.jpa.Etat;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote
public class ColisOperationBean implements ColisOperation {
	
	@PersistenceContext
	private EntityManager em;
	
	public ColisOperationBean() {}

	@Override
	public Colis creeColis(double poids, double valeur, String origine, String destination) {
		Colis colis = new Colis(poids,valeur,origine,destination);
		em.persist(colis);
		return colis;
	}

	@Override
	public Colis getColis(int unique_id) {
		return em.find(Colis.class, unique_id);
	}

	@Override
	public List<Colis> getAllColis() {
		Query requete = em.createNamedQuery("all");
		return requete.getResultList();
	}

	@Override
	public void updateColis(Colis colis) {
		em.merge(colis);
	}

	@Override
	public String suivreColis(Colis colis) {
		return colis.getAcheminements().get(colis.getAcheminements().size()).getEtat().toString();
	}

	public Acheminement creeAcheminement(int latitude, int longitude, String emplacement, Etat etat, Date date, Colis colis) {
		Acheminement acheminement = new Acheminement(latitude,longitude,emplacement,etat,date,colis);
		em.persist(acheminement);
		return acheminement;
	}

}
