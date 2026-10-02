package edu.pe.uls.ucos.demojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity 
public class Repuesto {

    @Id 
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sec_repuesto" )
    @SequenceGenerator( name = "sec_repuesto", sequenceName = "sec_repuesto", allocationSize = 1 )
    private int id;
    private String nombre;
    private String marca;
    private double precio;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}