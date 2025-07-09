package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class CitaDao {
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Cita cita) {
		em.persist(cita);
		
	}

	
	public void update(Cita cita) {
		em.merge(cita);
	}
	
	public Cita read(String citaID) {
		Cita cita = em.find(Cita.class, citaID);
		return cita;
	}
	
	public void delete(String citaID) {
		Cita cita = this.read(citaID);
		em.remove(cita);
	}
	
	public List<Cita> getAll() {
	    String jpql = "SELECT p FROM Cita p";
	    TypedQuery<Cita> q = em.createQuery(jpql, Cita.class);
	    return q.getResultList();
	}

}