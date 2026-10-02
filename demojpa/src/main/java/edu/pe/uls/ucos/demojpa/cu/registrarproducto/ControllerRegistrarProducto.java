package edu.pe.uls.ucos.demojpa.cu.registrarproducto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.uls.ucos.demojpa.cu.registrarproducto.request.RequestProducto;
import edu.pe.uls.ucos.demojpa.cu.registrarproducto.response.ResponseProducto;

@RestController
public class ControllerRegistrarProducto {

    private final ServiceRegistrarProducto serviceRegistrarProducto;

    public ControllerRegistrarProducto(ServiceRegistrarProducto serviceRegistrarProducto) {
        this.serviceRegistrarProducto = serviceRegistrarProducto;
    }

    @PostMapping("/producto/marca/{idMarca}/nuevo")
    public ResponseProducto registrarProducto(
            @PathVariable int idMarca,
            @RequestBody RequestProducto request) {
        return serviceRegistrarProducto.registrarProducto(idMarca, request);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseProducto consultarProducto(@PathVariable int idProducto) {
        return serviceRegistrarProducto.consultarProducto(idProducto);
    }
}
