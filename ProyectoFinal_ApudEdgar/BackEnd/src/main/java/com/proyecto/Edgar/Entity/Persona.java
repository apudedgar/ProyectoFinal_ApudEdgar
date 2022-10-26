/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Edgar.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author USURIO
 */
@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1,max=50, message="Minimo 1, Maximo 50 caracteres requeridos")
    private String nombre;
    @NotNull
    @Size(min=1,max=50, message="Minimo 1, Maximo 50 caracteres requeridos")
    private String apellido;
    @Size(min=1,max=50, message="Minimo 1, Maximo 50 caracteres requeridos")
    private String img;
    
    
}
