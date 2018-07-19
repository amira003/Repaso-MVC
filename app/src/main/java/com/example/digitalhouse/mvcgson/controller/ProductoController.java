package com.example.digitalhouse.mvcgson.controller;

import android.content.Context;

import com.example.digitalhouse.mvcgson.model.dao.DAOProducto;
import com.example.digitalhouse.mvcgson.model.dao.DAORetrofitProducto;
import com.example.digitalhouse.mvcgson.model.pojo.Producto;
import com.example.digitalhouse.mvcgson.util.HTTPConnectionManager;
import com.example.digitalhouse.mvcgson.util.ResultListener;

import java.util.List;

import retrofit2.http.HTTP;

/**
 * Created by DH on 16/7/2018.
 */

public class ProductoController {

    public void getProductos(final ResultListener<List<Producto>> escuchadorDeLaVista, Context context) {

        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            DAORetrofitProducto daoRetrofitProducto = new DAORetrofitProducto();
            daoRetrofitProducto.getAllProducts(new ResultListener<List<Producto>>() {
                @Override
                public void finish(List<Producto> resultado) {
                    escuchadorDeLaVista.finish(resultado);
                }
            });
        } else {
            DAOProducto daoProducto = new DAOProducto();
            List<Producto> lista = daoProducto.getListaDeProductosFromArchivo();
            escuchadorDeLaVista.finish(lista);

        }
    }

}
