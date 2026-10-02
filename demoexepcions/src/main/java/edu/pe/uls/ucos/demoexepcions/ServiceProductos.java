package edu.pe.uls.ucos.demoexepcions;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service 
public class ServiceProductos {

    public Producto registrarProducto( Producto nuevo){
        if(nuevo.getNombre().length()<2){
            
            throw new ProductoInvalidoException("nombre del producto debe tener 2 carateres minimo"); 
        }
        Date ahora = new Date();
        nuevo.setId((int) ahora.getTime());
        return nuevo;
    }
}
