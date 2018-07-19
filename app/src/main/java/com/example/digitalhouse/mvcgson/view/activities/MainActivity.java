package com.example.digitalhouse.mvcgson.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.digitalhouse.mvcgson.R;
import com.example.digitalhouse.mvcgson.controller.ProductoController;
import com.example.digitalhouse.mvcgson.model.pojo.Producto;
import com.example.digitalhouse.mvcgson.util.ResultListener;
import com.example.digitalhouse.mvcgson.view.adapters.AdapterProducto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewProductos = findViewById(R.id.recycler_productos);

        final AdapterProducto adapterProducto = new AdapterProducto(new ArrayList<Producto>(), this);

        ProductoController productoController = new ProductoController();

        productoController.getProductos(new ResultListener<List<Producto>>() {
            @Override
            public void finish(List<Producto> resultado) {
                adapterProducto.setProductos(resultado);
            }
        }, this);

        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recyclerViewProductos.setAdapter(adapterProducto);
    }
}
