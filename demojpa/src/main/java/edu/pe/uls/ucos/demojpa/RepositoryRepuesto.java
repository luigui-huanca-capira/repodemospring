package edu.pe.uls.ucos.demojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface RepositoryRepuesto extends JpaRepository<Repuesto, Integer> {
    List<Repuesto> findByMarca(String nombre);
    List<Repuesto> findByNombreContainingIgnoreCase(String texto);
}
