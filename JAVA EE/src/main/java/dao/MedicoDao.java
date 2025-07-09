package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class MedicoDao {
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Medico medico) {
		em.persist(medico);
		
	}

	
	public void update(Medico medico) {
		em.merge(medico);
	}
	
	public Medico read(String medID) {
		Medico medico = em.find(Medico.class, medID);
		return medico;
	}
	
	public void delete(String medID) {
		Medico medico = this.read(medID);
		em.remove(medico);
	}
	
	public List<Medico> getAll() {
	    String jpql = "SELECT p FROM Medico p";
	    TypedQuery<Medico> q = em.createQuery(jpql, Medico.class);
	    return q.getResultList();
	}

}