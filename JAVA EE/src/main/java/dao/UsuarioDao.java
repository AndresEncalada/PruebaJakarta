package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class UsuarioDao {
	
	
	@PersistenceContext(unitName = "PersonaService")
	private EntityManager em;
	
	public void insert (Usuario usuario) {
		em.persist(usuario);
		
	}

	
	public void update(Usuario Usuario) {
		em.merge(Usuario);
	}
	
	public Usuario read(String personalID) {
		Usuario Usuario = em.find(Usuario.class, personalID);
		return Usuario;
	}
	
	public void delete(String personalID) {
		Usuario Usuario = this.read(personalID);
		em.remove(Usuario);
	}
	
	public List<Usuario> getAll() {
	    String jpql = "SELECT p FROM Usuario p";
	    TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
	    return q.getResultList();
	}

}
