package edu.pe.uls.ucos.demoexepcions;

import java.time.LocalDate;

public class Producto {

    int id;
    String nombre;
    String descripcion;
    double precio;
    int stock;
    LocalDate fechaOrden;
    LocalDate fechaVencimiento;
    public Producto(int id, String nombre, String descripcion, double precio, int stock, LocalDate fechaOrden,
            LocalDate fechaVencimiento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaOrden = fechaOrden;
        this.fechaVencimiento = fechaVencimiento;
    }
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public LocalDate getFechaOrden() {
        return fechaOrden;
    }
    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}