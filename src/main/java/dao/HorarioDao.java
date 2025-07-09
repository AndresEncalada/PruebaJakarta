package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class HorarioDao {
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Horario horario) {
		em.persist(horario);
		
	}

	
	public void update(Horario horario) {
		em.merge(horario);
	}
	
	public Horario read(String horarioID) {
		Horario horario = em.find(Horario.class, horarioID);
		return horario;
	}
	
	public void delete(String horarioID) {
		Horario horario = this.read(horarioID);
		em.remove(horario);
	}
	
	public List<Horario> getAll() {
	    String jpql = "SELECT p FROM Horario p";
	    TypedQuery<Horario> q = em.createQuery(jpql, Horario.class);
	    return q.getResultList();
	}

}