/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

/**
 *
 * @author daniel
 */
public class TestManejoPersonas {

    public static void main(String[] args) {
        var personaDAO = new PersonaDAO();
        //System.out.println(personaDAO.actualizar(new Persona(3, "Johana", "Jaramillo", "johana@gmail.com", 32004507)));
        //personaDAO.insertar(new Persona("Kelly", "Jaramillo", "guira@gmail.com", 321589654));
        personaDAO.eliminar(new Persona(1));
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach((var persona) -> System.out.println("Persona = " + persona));

    }
}
