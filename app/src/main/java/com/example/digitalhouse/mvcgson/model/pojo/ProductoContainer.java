package com.example.digitalhouse.mvcgson.model.pojo;

import java.util.List;

/**
 * Created by DH on 16/7/2018.
 */

public class ProductoContainer {

    private List<Producto> productos;

    public ProductoContainer(List<Producto> productoList) {
        this.productos = productoList;
    }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productoList) { this.productos = productoList; }
}
