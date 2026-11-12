package com.ferreteria.maab.model;


import jakarta.persistence.*;


@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private long codProducto;
private String nombre;
private String marca;
private String categoria;
private Double precio;
private int stock;
private String descripcion;


public Producto() {

}

public Producto(long codProducto, String descripcion, int stock, Double precio, String categoria, String marca, String nombre) {
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
        this.nombre = nombre;
    }


    public long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(long codProducto) {
        this.codProducto = codProducto;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}// producto
