// src/app/models/persona.ts
export interface Persona {
  perID: number; // O number | null si el ID es opcional al crear
  nombre: string;
  apellido: string;
  nombrePartido: string;
  nombreVicepresidente: string;
}   