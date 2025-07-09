import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { CommonModule } from '@angular/common'; 

@Component({
  selector: 'app-root',
  standalone: true, 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [FormsModule, CommonModule]
})
export class AppComponent {
  title = 'nombre-del-proyecto';
  nombre: string = '';
  direccion: string = '';

  datosTabla: { nombre: string; direccion: string }[] = [];

  contactos: any
  constructor (private contactosServices: ContactosService){
  }
  guardarDatos() {
    console.log('Guardando datos:', this.nombre, this.direccion);
    const registro = { nombre: this.nombre, direccion: this.direccion };
    const datos = localStorage.getItem('datos');
    const lista = datos ? JSON.parse(datos) : [];
    lista.push(registro);
    localStorage.setItem('datos', JSON.stringify(lista));
    this.obtenerDatos();
    this.contactosServices.addContacto(this.nombre, this.direccion)
  }

  obtenerDatos() {
    const datos = localStorage.getItem('datos');
    this.datosTabla = datos ? JSON.parse(datos) : [];
  }
  eliminarDatos(){
    const datos = localStorage.getItem('datos');
    var lista = datos ? JSON.parse(datos) : [];
    lista=lista.filter((item: { nombre: string; }) => item.nombre !== this.nombre);
    localStorage.setItem('datos', JSON.stringify(lista));
    this.obtenerDatos();
  }
  actualizarDatos(): void {
    const datos = localStorage.getItem('datos');
    var lista = datos ? JSON.parse(datos) : [];
    const index = lista.findIndex((item: { nombre: string; }) => item.nombre === this.nombre);

    if (index > -1) {
      lista[index].direccion = this.direccion;
      localStorage.setItem('datos', JSON.stringify(lista));
    } else {
      console.log(`No se encontró ningún item con el nombre "${this.nombre}".`);
    }
    
    this.obtenerDatos();

  }
  async ngOnInit() {
    this.obtenerDatos();
    this.contactos = await contactosServices.getContactos()
    console.log("this.contactos",this.contactos)
  }
}
