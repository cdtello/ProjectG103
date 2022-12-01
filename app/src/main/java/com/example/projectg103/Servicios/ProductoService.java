package com.example.projectg103.Servicios;

import android.database.Cursor;

import com.example.projectg103.Entidades.Producto;
import com.example.projectg103.R;

import java.util.ArrayList;

public class ProductoService {
    public ArrayList<Producto> cursorToArray(Cursor cursor){
        ArrayList<Producto> list = new ArrayList<>();
        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                Producto producto = new Producto(
                        R.drawable.producto1,
                        cursor.getString(1),
                        cursor.getString(2),
                        Integer.parseInt(cursor.getString(3))
                );
                list.add(producto);
            }
        }
        return list;
    }
}
