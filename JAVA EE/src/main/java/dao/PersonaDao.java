package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import modelos.*;

@Stateless
public class PersonaDao {
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Persona persona) {
		em.persist(persona);
		
	}

	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(String cedula) {
		Persona persona = em.find(Persona.class, cedula);
		return persona;
	}
	public Persona read2(String nombre) {
		Persona persona = em.find(Persona.class, nombre);
		return persona;
	}
	
	public void delete(String cedula) {
		Persona persona = this.read(cedula);
		em.remove(persona);
	}
	public List<Persona> findByNameStartingWith(String prefix) {
        // JPQL para buscar por nombre que empieza con el prefijo
        // LOWER() se usa para hacer la búsqueda insensible a mayúsculas/minúsculas
        // El '%' al final del parámetro ':prefix' hace que busque 'que empieza con'
        TypedQuery<Persona> query = em.createQuery(
            "SELECT p FROM Persona p WHERE LOWER(p.nombre) LIKE :prefix", Persona.class);

        // Establece el parámetro de la consulta, asegurándote de que también esté en minúsculas
        // y añadiendo el comodín '%' al final.
        query.setParameter("prefix", prefix.toLowerCase() + "%");

        return query.getResultList();
    }
	
	public List<Persona> getAll() {
	    String jpql = "SELECT p FROM Persona p";
	    TypedQuery<Persona> q = em.createQuery(jpql, Persona.class);
	    return q.getResultList();
	}

}
