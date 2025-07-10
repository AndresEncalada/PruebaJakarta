import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PersonaBackendService } from '../app/servicios/persona.service';
import { Persona } from './modelos/persona';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [FormsModule, CommonModule]
})
export class AppComponent {
  title = 'Prueba';
  nombre: string = '';
  apellido: string = '';
  nombrePartido: string = ''; 
  nombreVicepresidente: string = ''; 

  datosTabla: Persona[] = []; 
 constructor(private personaService: PersonaBackendService) { } 

 obtenerDatos() {
    // Elimina todo lo relacionado con localStorage y Firebase
    this.personaService.getPersonas().subscribe(
      (data: Persona[]) => {
        this.datosTabla = data;
        console.log('Personas obtenidas:', data);
      },
      (error) => {
        console.error('Error al obtener personas:', error.message);
        // Puedes mostrar el error en el HTML
      }
    );
  }

  // --- Método para guardar datos (refactorizado) ---
  guardarDatos() { // Ya no necesitas 'async' a menos que uses otras promesas
    console.log('Guardando datos en el backend (Persona)...');

    // Crea un objeto Persona para enviar al backend
    const nuevaPersona: Persona = {
      perID: 0, // El backend generará el ID, puedes enviar 0 o null
      nombre: this.nombre,
      apellido: this.apellido,
      nombreVicepresidente: this.nombreVicepresidente,
      nombrePartido: this.nombrePartido // Asegúrate de incluir todos los campos necesarios
    };

    // Llama al servicio para guardar la persona
    this.personaService.savePersona(nuevaPersona).subscribe(
      (personaGuardada: Persona) => {
        console.log('Persona guardada exitosamente:', personaGuardada);
        // Limpia el formulario
        this.nombre = '';
        this.apellido = '';
        this.nombreVicepresidente = '';
        this.nombrePartido = '';
        // Vuelve a cargar los datos para actualizar la tabla
        this.obtenerDatos();
      },
      (error) => {
        console.error('Error al guardar persona:', error.message);
        // Muestra un mensaje de error al usuario
      }
    );
  }
  ngOnInit() {
    this.obtenerDatos();
  }
}
