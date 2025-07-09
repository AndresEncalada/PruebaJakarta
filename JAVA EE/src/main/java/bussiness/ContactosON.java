package bussiness;

import java.util.List;

import dao.PersonaDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import modelos.Persona;

@Stateless
public class ContactosON {
	
	@Inject
	private PersonaDao daoPersona;
	
	public void guardarPersona(Persona p) {
		Persona aux= daoPersona.read(p.getCedula());
		if(aux==null) {
			daoPersona.insert(p);
		}
		else {
			daoPersona.update(p);
		}
		
	}
	public List<Persona> getPersonasByNombreStartingWith(String prefix) throws Exception {
        // Aquí puedes añadir alguna lógica de negocio adicional si la necesitas.
        // Por ejemplo, validación del prefijo, logging, etc.
        if (prefix == null || prefix.trim().isEmpty()) {
            // Opcional: Si el prefijo está vacío, podrías devolver todas las personas
            // o lanzar una excepción, según la lógica de tu negocio.
            // Para este ejemplo, devolveremos una lista vacía si el prefijo es nulo/vacío.
            return daoPersona.getAll(); // O throw new IllegalArgumentException("El prefijo de búsqueda no puede estar vacío.");
        }
        return daoPersona.findByNameStartingWith(prefix);
    }
	public List<Persona> getContactos(){
		return daoPersona.getAll();
	}
	public Persona getContacto(String cedula) {
		return daoPersona.read(cedula);
	}
	public Persona getContacto2(String nombre) {
		return daoPersona.read2(nombre);
	}
}
