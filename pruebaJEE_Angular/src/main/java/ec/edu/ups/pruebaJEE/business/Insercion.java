package ec.edu.ups.pruebaJEE.business;

import java.util.List;

import ec.edu.ups.pruebaJEE.dao.*;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ec.edu.ups.pruebaJEE.modelos.*;

@Singleton
@Startup
public class Insercion {
	@Inject
	private PersonaDAO daoPersona;
	
	@PostConstruct
	public void init() {
		System.out.println("Inicializando BD");
		
		Persona presidente = new Persona();
		presidente.setNombre("Andres");
		presidente.setApellido("Encalada");
		presidente.setNombrePartido("binomio1");
		presidente.setNombreVicepresidente("Bryan Acevedo");
		
		daoPersona.insert(presidente);
		
		List<Persona> personas = daoPersona.getAll();
		for(Persona u : personas){
			System.out.println(u.toString() + "| ID generado: " + u.getPerID());
		}
	}
}