package com.example.digitalhouse.mvcgson.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.digitalhouse.mvcgson.R;
import com.example.digitalhouse.mvcgson.model.pojo.Producto;

import java.util.List;

/**
 * Created by digitalhouse on 01/06/17.
 */

public class AdapterProducto extends RecyclerView.Adapter {

    private List<Producto> listaDeProductos;
    private Context context;

    public AdapterProducto(List<Producto> listaDeProductos, Context context) {
        this.listaDeProductos = listaDeProductos;
        this.context = context;
    }

    public void setProductos(List<Producto> listaDeProductosNuevos){
        this.listaDeProductos.clear();
        this.listaDeProductos.addAll(listaDeProductosNuevos);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.celda_producto_recycler, parent, false);
        ProductosViewHolder productosViewHolder = new ProductosViewHolder(view);
        return productosViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Producto producto = listaDeProductos.get(position);
        ProductosViewHolder productosViewHolder = (ProductosViewHolder) holder;
        productosViewHolder.bindProducto(producto);
    }

    @Override
    public int getItemCount() {
        return listaDeProductos.size();
    }

    private class ProductosViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNombre;
        TextView textViewPrecio;
        TextView textViewDescripcion;

        public ProductosViewHolder(View itemView) {
            super(itemView);

            textViewNombre = (TextView) itemView.findViewById(R.id.textview_nombre_producto);
            textViewPrecio = (TextView) itemView.findViewById(R.id.textview_precio_producto);
            textViewDescripcion = (TextView) itemView.findViewById(R.id.textview_descripcion_producto);
        }

        public void bindProducto (Producto producto){
            textViewNombre.setText(producto.getNombre());
            textViewPrecio.setText(producto.getPrecio().toString());
            textViewDescripcion.setText(producto.getDescription());
        }
    }
}
