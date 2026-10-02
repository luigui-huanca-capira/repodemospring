package edu.pe.uls.ucos.demojpa.cu.registrarpedido;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.uls.ucos.demojpa.cu.registrarpedido.request.RequestPedido;
import edu.pe.uls.ucos.demojpa.cu.registrarpedido.response.ResponsePedido;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController 
public class ControllerRegistrarPedido {

    ServiceRegistrarPedido serviceRegistrarPedido;

    public ControllerRegistrarPedido(ServiceRegistrarPedido serviceRegistrarPedido) {
        this.serviceRegistrarPedido = serviceRegistrarPedido;
    }

    @PostMapping("/pedido/nuevo")
    public ResponsePedido guardarPedido(@RequestBody RequestPedido pedido) {
        return serviceRegistrarPedido.registrarPedido(pedido);
    }

    @GetMapping("/pedido/producto/{productoId}")
    public List<ResponsePedido> buscarPedidosPorProductoId(@PathVariable int productoId) {
        return serviceRegistrarPedido.buscarPedidoPorProductoId(productoId);
    }

    @GetMapping("/pedido/producto/nombre/{productoNombre}")
    public List<ResponsePedido> buscarPedidosPorProductoNombre(@PathVariable String productoNombre) {
        return serviceRegistrarPedido.buscarPedidoPorProductoNombre(productoNombre);
    }
    
}