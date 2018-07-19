package com.example.digitalhouse.mvcgson.model.dao;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.digitalhouse.mvcgson.model.pojo.Producto;

import java.util.List;

/**
 * Created by DH on 18/7/2018.
 */

public class DAORoom {
    private RoomAbstractDatabase roomDatabase;

    public DAORoom(Context context) {
        roomDatabase = Room.databaseBuilder(context,
                RoomAbstractDatabase.class, "database-name").build();
    }

    public List<Producto> getAllProductos() {
        return roomDatabase.productDao().getAllProductos();
    }

    public void insertProductos(List<Producto> productoList) {
        roomDatabase.productDao().insertarProducto(productoList);
    }
}
