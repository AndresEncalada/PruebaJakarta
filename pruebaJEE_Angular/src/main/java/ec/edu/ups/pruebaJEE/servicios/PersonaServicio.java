// src/main/java/servicios/PersonaService.java (Actualizado con métodos de búsqueda)
package ec.edu.ups.pruebaJEE.servicios;

import ec.edu.ups.pruebaJEE.business.*;
import ec.edu.ups.pruebaJEE.modelos.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam; // Necesario para obtener parámetros de la URL
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
public class PersonaServicio{

    @Inject
    private Candidatos onContactos;

    // --- Métodos CRUD existentes ---

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPersona(Persona p) {
        try {
            onContactos.guardarPersona(p);
            return Response.status(Response.Status.CREATED).entity(p).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Error al guardar la persona: " + e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonas() {
        try {
            List<Persona> personas = onContactos.getContactos();
            if (personas.isEmpty()) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            return Response.ok(personas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Error al obtener personas: " + e.getMessage()).build();
        }
    }

    

    // --- NUEVOS MÉTODOS DE BÚSQUEDA POR PATH ---

    // 1. Método para buscar por ID
    // Ejemplo de URL: http://localhost:8080/jakartaee-hello-world/api/personas/123
    @GET
    @Path("/{id}") // El {id} en la URL se mapea al parámetro @PathParam("id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonaById(@PathParam("id") int id) {
        try {
            Persona persona = onContactos.getContacto(id); // Llama a tu lógica de negocio
            if (persona != null) {
                return Response.ok(persona).build(); // 200 OK y la persona encontrada
            } else {
                return Response.status(Response.Status.NOT_FOUND) // 404 Not Found
                               .entity("Persona con ID " + id + " no encontrada.").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                           .entity("Error al buscar persona por ID: " + e.getMessage())
                           .build();
        }
    }

    // 2. Método para buscar por nombre (que empiece con un prefijo)
    // Ejemplo de URL: http://localhost:8080/jakartaee-hello-world/api/personas/nombre/A
    // O: http://localhost:8080/jakartaee-hello-world/api/personas/nombre/Juan
    @GET
    @Path("/nombre/{prefix}") // /nombre/ es una sub-ruta, {prefix} es el parámetro de búsqueda
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonasByNombreStartingWith(@PathParam("prefix") String prefix) {
        try {
            List<Persona> personas = onContactos.getPersonasByNombreStartingWith(prefix); // Llama a tu lógica
            if (personas.isEmpty()) {
                return Response.status(Response.Status.NO_CONTENT).build(); // 204 No Content si no hay coincidencias
            }
            return Response.ok(personas).build(); // 200 OK y la lista de personas
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                           .entity("Error al buscar personas por nombre: " + e.getMessage())
                           .build();
        }
    }
}