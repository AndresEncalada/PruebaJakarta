package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dias;
    private String horaInicio;
    private String horaFin;
    private boolean descanso;
    private String horaDescanso;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDias() { return dias; }
    public void setDias(String dias) { this.dias = dias; }
    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }
    public boolean isDescanso() { return descanso; }
    public void setDescanso(boolean descanso) { this.descanso = descanso; }
    public String getHoraDescanso() { return horaDescanso; }
    public void setHoraDescanso(String horaDescanso) { this.horaDescanso = horaDescanso; }
}