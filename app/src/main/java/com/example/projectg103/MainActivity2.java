package com.example.projectg103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projectg103.Adaptadores.ProductoAdaptador;
import com.example.projectg103.Entidades.Producto;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ListView listViewProducts;
    ProductoAdaptador productoAdaptador;
    ArrayList<Producto> arrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);

        arrayProductos = new ArrayList<>();

        Producto producto1 = new Producto(R.drawable.producto1,"Producto1", "Descripcion 1", 1000);
        Producto producto2 = new Producto(R.drawable.producto2,"Producto2", "Descripcion 2", 2000);
        Producto producto3 = new Producto(R.drawable.producto3,"Producto3", "Descripcion 3", 3000);
        Producto producto4 = new Producto(R.drawable.producto1,"Producto4", "Descripcion 1", 1000);
        Producto producto5= new Producto(R.drawable.producto2,"Producto5", "Descripcion 2", 2000);
        Producto producto6 = new Producto(R.drawable.producto3,"Producto6", "Descripcion 3", 3000);
        Producto producto7 = new Producto(R.drawable.producto1,"Producto7", "Descripcion 1", 1000);
        Producto producto8 = new Producto(R.drawable.producto2,"Producto8", "Descripcion 2", 2000);
        Producto producto9 = new Producto(R.drawable.producto3,"Producto9", "Descripcion 3", 3000);

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        arrayProductos.add(producto7);
        arrayProductos.add(producto8);
        arrayProductos.add(producto9);

        Log.d("testProductos","Paso1");
        productoAdaptador = new ProductoAdaptador(getApplicationContext(), arrayProductos);
        Log.d("testProductos","Paso2");

        listViewProducts.setAdapter(productoAdaptador);
    }
}