package edu.pe.uls.ucos.demojpa.dominio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_marca")
    @SequenceGenerator(
        name = "sec_marca",
        sequenceName = "sec_marca",
        allocationSize = 1
    )
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}