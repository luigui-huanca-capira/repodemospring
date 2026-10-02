package edu.pe.uls.ucos.demojpa.cu.registrarproducto.response;

public record ResponseProducto(
        Integer id,
        Integer idMarca,
        String nombre,
        String descripcion,
        double precio,
        int stock) {
}
