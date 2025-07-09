package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class EspecialidadDao {
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Especialidad especialidad) {
		em.persist(especialidad);
		
	}

	
	public void update(Especialidad especialidad) {
		em.merge(especialidad);
	}
	
	public Especialidad read(String especialidadID) {
		Especialidad especialidad = em.find(Especialidad.class, especialidadID);
		return especialidad;
	}
	
	public void delete(String especialidadID) {
		Especialidad especialidad = this.read(especialidadID);
		em.remove(especialidad);
	}
	
	public List<Especialidad> getAll() {
	    String jpql = "SELECT p FROM Especialidad p";
	    TypedQuery<Especialidad> q = em.createQuery(jpql, Especialidad.class);
	    return q.getResultList();
	}

}