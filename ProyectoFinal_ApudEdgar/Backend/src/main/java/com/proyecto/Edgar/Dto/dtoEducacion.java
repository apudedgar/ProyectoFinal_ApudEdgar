/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Edgar.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author USURIO
 */
public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String anioE;
    
    //constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.anioE=anioE;
    }
    
    //get y set

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    public String getAnioE() {
        return anioE;
    }

    public void setAioE(String anioE) {
        this.anioE = anioE;
    }
}
