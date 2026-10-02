package edu.pe.uls.ucos.demoexepcions;

import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface MapperProducto {

    Producto toProducto(RequestProducto request);
}