package com.example.digitalhouse.mvcgson.model.dao;

import com.example.digitalhouse.mvcgson.model.pojo.Producto;
import com.example.digitalhouse.mvcgson.model.pojo.ProductoContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DH on 18/7/2018.
 */

public interface RetrofitServiceProducto {

    @GET("bins/624h/")
    Call<ProductoContainer> getAllProductos();




}
