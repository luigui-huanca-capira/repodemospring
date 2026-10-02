package edu.pe.uls.ucos.demojpa.cu.registrarpedido;

import java.util.ArrayList;
import java.util.List;

import edu.pe.uls.ucos.demojpa.cu.registrarpedido.exception.ProductoNoEncontradoException;
import edu.pe.uls.ucos.demojpa.cu.registrarpedido.exception.StockInsuficienteException;
import edu.pe.uls.ucos.demojpa.cu.registrarpedido.request.RequestPedido.RequestPedidoItem;
import edu.pe.uls.ucos.demojpa.cu.registrarpedido.response.ResponsePedido;
import edu.pe.uls.ucos.demojpa.dominio.entity.Pedido;
import edu.pe.uls.ucos.demojpa.dominio.entity.Producto;
import edu.pe.uls.ucos.demojpa.dominio.repository.RepoPedido;
import edu.pe.uls.ucos.demojpa.dominio.repository.RepoProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.uls.ucos.demojpa.cu.registrarpedido.request.RequestPedido;

@Service 
public class ServiceRegistrarPedido {

    RepoProducto repoProducto;

    RepoPedido repoPedido;

    public ServiceRegistrarPedido(RepoProducto repoProducto, RepoPedido repoPedido) {
        this.repoProducto = repoProducto;
        this.repoPedido = repoPedido;
    }

    @Transactional
    public ResponsePedido registrarPedido(RequestPedido pedido) {
        Pedido p = new Pedido();    
        List<ResponsePedido.ResponsePedidoItem> lst = new ArrayList<ResponsePedido.ResponsePedidoItem>();
        for (RequestPedidoItem item : pedido.items()) {
            System.out.println(System.currentTimeMillis() + " INICIO " + Thread.currentThread().getName());
            Producto producto = repoProducto.findById(item.idProducto())
                    .orElseThrow(() -> new ProductoNoEncontradoException(
                            "No se encontró el producto con id: " + item.idProducto()));
            System.out.println(System.currentTimeMillis() + " DESPUES DE FIND "
                    + Thread.currentThread().getName() + " stock=" + producto.getStock());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println(System.currentTimeMillis() + " DESPUES DE SLEEP "
                    + Thread.currentThread().getName());
            if (producto.getStock() < item.cantidad()) {
                throw new StockInsuficienteException(
                        "Stock insuficiente para el producto: " + producto.getNombre()
                                + ". Disponible: " + producto.getStock()
                                + ", Solicitado: " + item.cantidad());
            }
            p.agregarItem(producto, item.cantidad(), item.precioUnitario());
            lst.add(new ResponsePedido.ResponsePedidoItem(producto.getNombre(), item.cantidad()));
            producto.setStock(producto.getStock() - item.cantidad());
            repoProducto.save(producto);
        }
        repoPedido.save(p);
        ResponsePedido respPedido = new ResponsePedido(p.getId(), lst);
        return respPedido;
    }

    @Transactional(readOnly = true)
    public List<ResponsePedido> buscarPedidoPorProductoId(int productoId) {
        List<Pedido> pedidos = repoPedido.buscarPorProductoId(productoId);
        return pedidos.stream()
                .map(p -> new ResponsePedido(
                        p.getId(),
                        p.getItems().stream()
                                .map(item -> new ResponsePedido.ResponsePedidoItem(
                                        item.getProducto().getNombre(), item.getCantidad()))
                                .toList()))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ResponsePedido> buscarPedidoPorProductoNombre(String productoNombre) {
        List<Pedido> pedidos = repoPedido.buscarPorProductoNombre("%" + productoNombre + "%");
        return pedidos.stream()
                .map(p -> new ResponsePedido(
                        p.getId(),
                        p.getItems().stream()
                                .map(item -> new ResponsePedido.ResponsePedidoItem(
                                        item.getProducto().getNombre(), item.getCantidad()))
                                .toList()))
                .toList();
    }
}
