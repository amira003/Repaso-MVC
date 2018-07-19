package com.example.digitalhouse.mvcgson.controller;

import android.content.Context;

import com.example.digitalhouse.mvcgson.model.dao.DAOProducto;
import com.example.digitalhouse.mvcgson.model.dao.DAORetrofitProducto;
import com.example.digitalhouse.mvcgson.model.dao.DAORoom;
import com.example.digitalhouse.mvcgson.model.pojo.Producto;
import com.example.digitalhouse.mvcgson.util.HTTPConnectionManager;
import com.example.digitalhouse.mvcgson.util.ResultListener;

import java.util.List;

import retrofit2.http.HTTP;

/**
 * Created by DH on 16/7/2018.
 */

public class ProductoController {

    public void getProductos(final ResultListener<List<Producto>> escuchadorDeLaVista, final Context context) {

        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            final DAORetrofitProducto daoRetrofitProducto = new DAORetrofitProducto();
            ResultListener<List<Producto>> escuchadorDelDao =new ResultListener<List<Producto>>() {
                @Override
                public void finish(List<Producto> resultado) {
                    DAORoom daoRoom = new DAORoom(context);
                    daoRoom.insertProductos(resultado);
                    escuchadorDeLaVista.finish(resultado);
                }
            };
            daoRetrofitProducto.getAllProducts(escuchadorDelDao);

        } else {
            DAORoom daoRoom = new DAORoom(context);
            List<Producto> productoList = daoRoom.getAllProductos();
            escuchadorDeLaVista.finish(productoList);

        }
    }

}
