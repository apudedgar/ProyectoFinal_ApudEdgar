/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Edgar.Interface;

import com.proyecto.Edgar.Entity.Persona;
import java.util.List;

/**
 *
 * @author USURIO
 */

public interface IPersonaService {
    //Traer Lista de Personas
    public List<Persona> getPersona();
    
    //Guardar Persona
   public void savePersona(Persona persona);
   
   //Eliminar persona por id
   public void deletePersona(Long id);
   
   //Buscar una persona por ID
   public Persona findPersona(Long id);
}
