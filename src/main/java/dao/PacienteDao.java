package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class PacienteDao {
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Paciente paciente) {
		em.persist(paciente);
		
	}

	
	public void update(Paciente paciente) {
		em.merge(paciente);
	}
	
	public Paciente read(String pacID) {
		Paciente paciente = em.find(Paciente.class, pacID);
		return paciente;
	}
	
	public void delete(String pacID) {
		Paciente paciente = this.read(pacID);
		em.remove(paciente);
	}
	
	public List<Paciente> getAll() {
	    String jpql = "SELECT p FROM Paciente p";
	    TypedQuery<Paciente> q = em.createQuery(jpql, Paciente.class);
	    return q.getResultList();
	}

}