package bussiness;

import java.util.List;

import dao.*;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import modelos.*;

@Singleton
@Startup
public class InicializarBD {
	@Inject
	private PersonaDao daoPersona;
	@Inject
	private UsuarioDao daoUsuario;
	@Inject
	private EspecialidadDao daoEspecialidad;
	@Inject
	private HorarioDao daoHorario;
	@Inject
	private CitaDao daoCita;
	
	@PostConstruct
	public void init() {
		System.out.println("Inicialización BD");
		Persona persona = new Persona();
		persona.setCedula("0950094508");
		persona.setNombre("Andrés");
		persona.setDireccion("Direccion 1");
		daoPersona.insert(persona);
		
		List<Persona> personas = daoPersona.getAll();
		for(Persona p : personas) {
			System.out.println(p.toString());
		}
		System.out.println("Inicializando BD");
		
		Especialidad especialidad = new Especialidad();
		especialidad.setNombre("Pediatría");
		
		daoEspecialidad.insert(especialidad);
		
		List<Especialidad> especialidades = daoEspecialidad.getAll();
		for(Especialidad e : especialidades){
			System.out.println(e.toString() + "| ID generado: " + e.getId());
		}
		
		Medico medico = new Medico();
		medico.setNombre("Alexandra Cabrera");
		medico.setCorreo("alex@gmail.com");
		medico.setTelefono("0984756419");
		medico.setCedula("0301116299");
		medico.setRol('a');
		medico.setEspecialidad(especialidad);
		
		Paciente paciente = new Paciente();
		paciente.setNombre("Jordy Espinoza");
		paciente.setCorreo("jordy@gmail.com");
		paciente.setTelefono("0984756421");
		paciente.setCedula("0301108312");
		paciente.setRol('p');
		paciente.setDireccion("Av. de las Américas");
		paciente.setGenero("Masculino");
		
		daoUsuario.insert(medico);
		daoUsuario.insert(paciente);
		
		List<Usuario> usuarios = daoUsuario.getAll();
		for(Usuario u : usuarios){
			System.out.println(u.toString() + "| ID generado: " + u.getPersonalID());
		}
	}
}