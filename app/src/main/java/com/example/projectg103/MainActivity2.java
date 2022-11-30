package com.example.projectg103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.projectg103.Adaptadores.ProductoAdapter;
import com.example.projectg103.Entidades.Producto;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listViewProducts;
    ProductoAdapter productoAdapter;
    ArrayList<Producto> arrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProductos = new ArrayList<>();
        Producto producto1 = new Producto(R.drawable.producto1,"Producto 1", "Descripcion 1",1000);
        Producto producto2 = new Producto(R.drawable.producto2,"Producto 2", "Descripcion 2",2000);
        Producto producto3 = new Producto(R.drawable.producto3,"Producto 3", "Descripcion 3",3000);
        Producto producto4 = new Producto(R.drawable.producto1,"Producto 4", "Descripcion 4",4000);
        Producto producto5 = new Producto(R.drawable.producto2,"Producto 5", "Descripcion 5",5000);
        Producto producto6 = new Producto(R.drawable.producto3,"Producto 6", "Descripcion 6",6000);
        Producto producto7 = new Producto(R.drawable.producto1,"Producto 7", "Descripcion 7",7000);
        Producto producto8 = new Producto(R.drawable.producto2,"Producto 8", "Descripcion 8",8000);
        Producto producto9 = new Producto(R.drawable.producto3,"Producto 9", "Descripcion 9",9000);

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        arrayProductos.add(producto7);
        arrayProductos.add(producto8);
        arrayProductos.add(producto9);

        productoAdapter = new ProductoAdapter(this, arrayProductos);

        listViewProducts.setAdapter(productoAdapter);

    }
}