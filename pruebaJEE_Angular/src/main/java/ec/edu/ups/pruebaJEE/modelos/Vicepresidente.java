package ec.edu.ups.pruebaJEE.modelos;

import jakarta.persistence.*;

@Entity
public class Vicepresidente extends Persona{
	private String nombrePartido;
	public String getNombrePartido() {
		return nombrePartido;
	}
	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}
	@Override
	public String toString() {
		return "Presidente [nombrePartido=" + nombrePartido + "]";
	}
	
	

}
