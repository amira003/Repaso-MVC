package com.example.digitalhouse.mvcgson.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.digitalhouse.mvcgson.model.pojo.Producto;

import java.util.List;

/**
 * Created by DH on 18/7/2018.
 */
@Dao
public interface RoomServiceProducto {

    @Query("SELECT * FROM Producto")
    List<Producto> getAllProductos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarProducto(Producto... producto);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarProducto(List<Producto> productoList);

    @Delete
    void borrarProducto(Producto producto);
}
