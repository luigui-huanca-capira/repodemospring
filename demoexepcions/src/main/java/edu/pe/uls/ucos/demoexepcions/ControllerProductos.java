package edu.pe.uls.ucos.demoexepcions;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class ControllerProductos {

    
    ServiceProductos serviceProductos;
    MapperProducto mapperProducto;
    public  ControllerProductos(ServiceProductos serviceProductos, MapperProducto mapperProducto){
        this.serviceProductos=serviceProductos;
        this.mapperProducto=mapperProducto;
    }
    
    
    @PostMapping("/producto/nuevo")
    public Producto guardarProducto(@RequestBody RequestProducto request) {
        Producto pro = mapperProducto.toProducto(request);
        pro =serviceProductos.registrarProducto(pro);
        return pro;
    }
    
}
    

