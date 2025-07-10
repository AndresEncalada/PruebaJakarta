package ec.edu.ups.pruebaJEE.modelos;

import jakarta.persistence.*;

@Entity
public class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int perID;
	private String nombre;
	private String Apellido;
	private String nombrePartido;
	private String nombreVicepresidente;
	
	public int getPerID() {
		return perID;
	}
	public void setPerID(int perID) {
		this.perID = perID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNombrePartido() {
		return nombrePartido;
	}
	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}
	public String getNombreVicepresidente() {
		return nombreVicepresidente;
	}
	public void setNombreVicepresidente(String nombreVicepresidente) {
		this.nombreVicepresidente = nombreVicepresidente;
	}
	@Override
	public String toString() {
		return "Persona [perID=" + perID + ", nombre=" + nombre + ", Apellido=" + Apellido + ", nombrePartido="
				+ nombrePartido + ", nombreVicepresidente=" + nombreVicepresidente + "]";
	}
	
	
	
}
