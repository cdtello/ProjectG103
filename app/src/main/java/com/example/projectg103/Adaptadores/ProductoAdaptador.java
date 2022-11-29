package com.example.projectg103.Adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectg103.Entidades.Producto;
import com.example.projectg103.R;

import java.util.ArrayList;

public class ProductoAdaptador extends BaseAdapter {
    Context context;
    ArrayList<Producto> listaProductos;
    LayoutInflater inflater;

    public ProductoAdaptador(Context context, ArrayList<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null){
            convertView = inflater.inflate(R.layout.producto_template,null);

        }
        ImageView imgProduct = convertView.findViewById(R.id.imgProduct);
        TextView textNameProduct = convertView.findViewById(R.id.textNameProduct);
        TextView textDescriptionProduct = convertView.findViewById(R.id.textDescriptionProduct);
        TextView textPriceProduct = convertView.findViewById(R.id.textPriceProduct);

        Producto producto = listaProductos.get(position);

        imgProduct.setImageResource(producto.getImagen());
        textNameProduct.setText(producto.getNombre());
        textDescriptionProduct.setText(producto.getDescripcion());
        textPriceProduct.setText(String.valueOf(producto.getPrecio()));

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), "Presionado: "+producto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
