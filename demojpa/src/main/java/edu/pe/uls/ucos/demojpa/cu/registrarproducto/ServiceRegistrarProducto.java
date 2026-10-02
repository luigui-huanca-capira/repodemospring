package edu.pe.uls.ucos.demojpa.cu.registrarproducto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.uls.ucos.demojpa.cu.registrarproducto.exception.MarcaNoEncontradaException;
import edu.pe.uls.ucos.demojpa.cu.registrarproducto.request.RequestProducto;
import edu.pe.uls.ucos.demojpa.cu.registrarproducto.response.ResponseProducto;
import edu.pe.uls.ucos.demojpa.cu.registrarpedido.exception.ProductoNoEncontradoException;
import edu.pe.uls.ucos.demojpa.dominio.entity.Marca;
import edu.pe.uls.ucos.demojpa.dominio.entity.Producto;
import edu.pe.uls.ucos.demojpa.dominio.repository.RepoMarca;
import edu.pe.uls.ucos.demojpa.dominio.repository.RepoProducto;

@Service
public class ServiceRegistrarProducto {

    private final RepoMarca repoMarca;
    private final RepoProducto repoProducto;

    public ServiceRegistrarProducto(RepoMarca repoMarca, RepoProducto repoProducto) {
        this.repoMarca = repoMarca;
        this.repoProducto = repoProducto;
    }

    @Transactional
    public ResponseProducto registrarProducto(int idMarca, RequestProducto request) {
        Marca marca = repoMarca.findById(idMarca)
                .orElseThrow(() -> new MarcaNoEncontradaException(
                        "No se encontró la marca con id: " + idMarca));

        Producto producto = new Producto();
        producto.setMarca(marca);
        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());

        Producto guardado = repoProducto.save(producto);
        return new ResponseProducto(
                guardado.getId(),
                guardado.getMarca().getId(),
                guardado.getNombre(),
                guardado.getDescripcion(),
                guardado.getPrecio(),
                guardado.getStock());
    }

    @Transactional(readOnly = true)
    public ResponseProducto consultarProducto(int idProducto) {
        Producto producto = repoProducto.findById(idProducto)
                .orElseThrow(() -> new ProductoNoEncontradoException(
                        "No se encontró el producto con id: " + idProducto));
        return new ResponseProducto(
                producto.getId(),
                producto.getMarca().getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock());
    }
}
