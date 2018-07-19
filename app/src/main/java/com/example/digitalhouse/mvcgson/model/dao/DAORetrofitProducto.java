package com.example.digitalhouse.mvcgson.model.dao;

import com.example.digitalhouse.mvcgson.model.pojo.Producto;
import com.example.digitalhouse.mvcgson.model.pojo.ProductoContainer;
import com.example.digitalhouse.mvcgson.util.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DH on 18/7/2018.
 */

public class DAORetrofitProducto {

    private String urlBase;
    private Retrofit retrofit;
    private RetrofitServiceProducto retrofitServiceProducto;

    public DAORetrofitProducto() {
        this.urlBase = "@strings/urlBase";
        retrofit = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        retrofitServiceProducto = retrofit.create(RetrofitServiceProducto.class);
    }

    /**
     * Los métodos, al ser asincrónicos, no devuelven nada. En cambio, reciben un escuchador desde
     * el controlador.
     */

    public void getAllProducts(final ResultListener<List<Producto>> escuchadorDelControlador) {
        Call<ProductoContainer> call = retrofitServiceProducto.getAllProductos();
        call.enqueue(new Callback<ProductoContainer>() {
            @Override
            public void onResponse(Call<ProductoContainer> call, Response<ProductoContainer> response) {
                escuchadorDelControlador.finish(response.body().getProductos());
            }

            @Override
            public void onFailure(Call<ProductoContainer> call, Throwable t) {

            }
        });
    }
}
