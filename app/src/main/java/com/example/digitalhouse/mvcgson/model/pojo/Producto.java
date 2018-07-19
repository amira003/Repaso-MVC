package com.example.digitalhouse.mvcgson.model.pojo;

/**
 * Created by digitalhouse on 01/06/17.
 */

public class Producto {

    private String nombre;
    private String precio;
    private String description;

    public Producto() {

    }

    public Producto(String nombre, String precio, String description) {
        this.nombre = nombre;
        this.precio = precio;
        this.description = description;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
