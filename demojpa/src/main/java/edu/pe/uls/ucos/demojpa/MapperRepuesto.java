package edu.pe.uls.ucos.demojpa;

import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface MapperRepuesto {

    Repuesto toRepuesto(RequestRepuesto request);

    ResponseRepuesto toResponse(Repuesto repuesto);
}
