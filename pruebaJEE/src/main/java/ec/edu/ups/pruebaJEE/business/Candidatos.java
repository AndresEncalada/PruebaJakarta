package ec.edu.ups.pruebaJEE.business;

import java.util.List;

import ec.edu.ups.pruebaJEE.dao.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ec.edu.ups.pruebaJEE.modelos.*;

@Stateless
public class Candidatos {

	@Inject
	private PersonaDAO daoPersona;
	
	public void guardarPersona(Persona p) {
		Persona aux= daoPersona.read(p.getPerID());
		if(aux==null) {
			daoPersona.insert(p);
		}
		else {
			daoPersona.update(p);
		}
		
	}
	public List<Persona> getPersonasByNombreStartingWith(String prefix) throws Exception {
        if (prefix == null || prefix.trim().isEmpty()) {
        }
        return daoPersona.findByNameStartingWith(prefix);
    }
	public List<Persona> getContactos(){
		return daoPersona.getAll();
	}
	public Persona getContacto(int perID) {
		return daoPersona.read(perID);
	}
	public Persona getContacto2(String nombre) {
		return daoPersona.read2(nombre);
	}
}
