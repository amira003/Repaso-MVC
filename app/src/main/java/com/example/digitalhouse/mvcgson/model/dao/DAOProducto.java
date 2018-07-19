package com.example.digitalhouse.mvcgson.model.dao;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.digitalhouse.mvcgson.model.pojo.Producto;
import com.example.digitalhouse.mvcgson.model.pojo.ProductoContainer;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by digitalhouse on 01/06/17.
 */

/**
 * fixme CLASE A DEPRECAR
 */
public class DAOProducto {

    public List<Producto> getListaDeProductosFromArchivo(){
        List<Producto>productoList = new ArrayList<>();

        productoList.add(new Producto("Birome espacial","$300","Birome que funciona en el espacio "));
        productoList.add(new Producto("Traje espacial","$1300","Traje que funciona en el espacio "));
        productoList.add(new Producto("Pelota de futbol","$500","La nueva pelota del mundial 2018 "));
        productoList.add(new Producto("Botines Adidas","$1400","Se Messi, y no otro CR7 o Modric cualquiera"));
        productoList.add(new Producto("Mollejas de Pollo","$200","Chiste, todos saben que las mollejas de pollo no existen"));
        productoList.add(new Producto("Medialunas DH","Gratis","Anuncios importantes "));

        return productoList;
    }
    //https://api.myjson.com/bins/624hi//

        //Creo un método para pedir la lista de productos del archivo Json
    public List<Producto> getListaDeProductosFromArchivo(Context context){
        List<Producto> listaDeProductos = new ArrayList<>();

        //Pedimos el assetManager para acceder a los archivos dentro de la carpeta assets
        AssetManager assetManager = context.getAssets();
        try {
            //Creamos un stream para leer el archivo Json.
            InputStream archivoJsonProductos = assetManager.open("listadeproductos.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(archivoJsonProductos));

            //Creamos un Objeto de la clase Gson que me permitirá sencillamente parsear el Json.
            Gson gson = new Gson();

            //Utilizando el objeto gson y el método fromJson, realizamos el parsing el archivo
            // que tenemos en el bufferReaderIn y utilizando como “molde” la clase ProductoContainer.
            ProductoContainer productoContainer = gson.fromJson(bufferedReader, ProductoContainer.class);
            listaDeProductos = productoContainer.getProductos();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Devuelvo la lista cargada
        return listaDeProductos;

    }

}
