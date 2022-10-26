/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Edgar.Security.Service;

import com.proyecto.Edgar.Security.Entity.Rol;
import com.proyecto.Edgar.Security.Enums.RolNombre;
import com.proyecto.Edgar.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USURIO
 */
@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    /**
     *
     * @param rolNombre
     * @return
     */
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
