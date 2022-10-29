/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Edgar.Controller;

import com.proyecto.Edgar.Dto.dtoPersona;
import com.proyecto.Edgar.Entity.Persona;
import com.proyecto.Edgar.Security.Controller.Mensaje;
import com.proyecto.Edgar.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USURIO
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://freedg-f4f04.web.app")
public class PersonaController {
    @Autowired ImpPersonaService imppersonaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = imppersonaService.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!imppersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = imppersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (imppersonaService.existsByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa persona ya esta cargada"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getDescripcion(), dtopersona.getTitulo(), dtopersona.getImg());
        imppersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona cargada"), HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        //Validacion si no existe id
        if (!imppersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        // Compara nombre de hYs
        if (imppersonaService.existsByNombre(dtopersona.getNombre()) && imppersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //No puede estar vacio
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = imppersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setImg(dtopersona.getImg());
        imppersonaService.save(persona);
        return new ResponseEntity(new Mensaje("skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validacion si no existe id
        if (!imppersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        imppersonaService.delete(id);
        return new ResponseEntity(new Mensaje("hys eliminada"), HttpStatus.OK);

    }
    
}
