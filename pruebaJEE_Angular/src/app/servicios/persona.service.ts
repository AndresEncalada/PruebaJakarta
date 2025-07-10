// src/app/persona.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Persona } from '../modelos/persona'; 

@Injectable({
  providedIn: 'root'
})
export class PersonaBackendService { 
  private apiUrl = 'http://localhost:8080/pruebaJEE/rest';

  constructor(private http: HttpClient) { }

  getPersonas(): Observable<Persona[]> {
    return this.http.get<Persona[]>(`${this.apiUrl}/personas`).pipe(
      catchError(this.handleError)
    );
  }

  savePersona(persona: Persona): Observable<Persona> {
    return this.http.post<Persona>(`${this.apiUrl}/personas`, persona).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Un error desconocido ocurrió.';
    if (error.error instanceof ErrorEvent) {
      console.error('Error del cliente o de la red:', error.error.message);
      errorMessage = `Error: ${error.error.message}`;
    } else {
      console.error(
        `Código de error del backend ${error.status}, ` +
        `cuerpo: ${error.error}`);
      errorMessage = `Error del servidor: ${error.status} - ${error.error}`;
    }
    return throwError(() => new Error(errorMessage));
  }
}