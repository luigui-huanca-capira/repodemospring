package edu.pe.uls.ucos.demojpa.dominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pe.uls.ucos.demojpa.dominio.entity.Pedido;

public interface RepoPedido extends JpaRepository<Pedido, Integer> {

    @Query("""
            select distinct p
            from Pedido p
            join fetch p.items item
            join fetch item.producto producto
            where producto.id = :productoId
            """)
    List<Pedido> buscarPorProductoId(@Param("productoId") int productoId);

    @Query("""
            select distinct p
            from Pedido p
            join fetch p.items item
            join fetch item.producto producto
            where lower(producto.nombre) like lower(:productoNombre)
            """)
    List<Pedido> buscarPorProductoNombre(@Param("productoNombre") String productoNombre);
}