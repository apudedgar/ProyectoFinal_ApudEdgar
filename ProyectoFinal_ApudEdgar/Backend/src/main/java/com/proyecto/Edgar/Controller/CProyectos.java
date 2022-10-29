/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Edgar.Controller;

import com.proyecto.Edgar.Dto.dtoProyectos;
import com.proyecto.Edgar.Entity.Proyectos;
import com.proyecto.Edgar.Security.Controller.Mensaje;
import com.proyecto.Edgar.Service.SProyectos;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
        @Autowired SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    /**
     *
     * @param dtoproyectos
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombreP es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyectos.existsByNombreP(dtoproyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("Esa persona ya esta cargada"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoproyectos.getNombreP(), dtoproyectos.getDescripcionP(), dtoproyectos.getImgP());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Persona cargada"), HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        //Validacion si no existe id
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        // Compara nombreP de hYs
        if (sProyectos.existsByNombreP(dtoproyectos.getNombreP()) && sProyectos.getByNombreP(dtoproyectos.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //No puede estar vacio
        if (StringUtils.isBlank(dtoproyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombreP no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreP(dtoproyectos.getNombreP());
        proyectos.setDescripcionP(dtoproyectos.getDescripcionP());
        proyectos.setImgP(dtoproyectos.getImgP());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validacion si no existe id
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("hys eliminada"), HttpStatus.OK);

    }
    

    
}
