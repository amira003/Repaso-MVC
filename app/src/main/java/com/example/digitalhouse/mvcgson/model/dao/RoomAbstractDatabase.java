package com.example.digitalhouse.mvcgson.model.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.digitalhouse.mvcgson.model.pojo.Producto;

/**
 * Created by DH on 18/7/2018.
 */

@Database(entities = {Producto.class}, version = 1)
public abstract class RoomAbstractDatabase extends RoomDatabase {
    public abstract RoomServiceProducto productDao();

}
