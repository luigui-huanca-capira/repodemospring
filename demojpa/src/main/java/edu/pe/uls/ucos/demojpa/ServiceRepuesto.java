package edu.pe.uls.ucos.demojpa;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceRepuesto {
    @Autowired
    RepositoryRepuesto repoRepuesto;
    public Repuesto registrarRepuesto(Repuesto nuevo){
        Repuesto repuesto = repoRepuesto.save(nuevo);
        return repuesto;
    }

    public Repuesto consultarRepuesto(int id) {
        return repoRepuesto.findById(id).get();
    }

    public List<Repuesto> consultarPorMarca(String marca) {
        return repoRepuesto.findByMarca(marca);
    }

    public List<Repuesto> consultarPorNombre(String nombre) {
        return repoRepuesto.findByNombreContainingIgnoreCase(nombre);
    }
}
