package modelos;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personalID;
    private String cedula;
    private String nombre;
    private String contactoC;
    private String telefono;
    private String correo;
    private boolean datos;
    private String direccion;
    private String estadoC;
    private String genero;
    private String nacionalidad;
    private Date fechaNac;
    private char rol;
    
    public Usuario () {
    	
    }
    
    // Getters y Setters
    public int getPersonalID() { return personalID; }
    public void setPersonalID(int personalID) { this.personalID = personalID; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getContactoC() { return contactoC; }
    public void setContactoC(String contactoC) { this.contactoC = contactoC; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public boolean isDatos() { return datos; }
    public void setDatos(boolean datos) { this.datos = datos; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEstadoC() { return estadoC; }
    public void setEstadoC(String estadoC) { this.estadoC = estadoC; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public Date getFechaNac() { return fechaNac; }
    public void setFechaNac(Date fechaNac) { this.fechaNac = fechaNac; }
    public char getRol() { return rol; }
    public void setRol(char rol) { this.rol = rol; }
} 