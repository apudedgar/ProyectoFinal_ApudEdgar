/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Edgar.Repository;

import com.proyecto.Edgar.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USURIO
 */
@Repository
public interface Rhys extends JpaRepository<hys, Integer>{
    public Optional<hys> findByNombre (String nombre);
    public boolean existsByNombre(String nombre);

}
