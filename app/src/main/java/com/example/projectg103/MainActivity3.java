package com.example.projectg103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectg103.DB.DBHelper;
import com.example.projectg103.Entidades.Producto;
import com.example.projectg103.Servicios.ProductoService;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private DBHelper dbHelper;
    private ProductoService productoService;
    private Button btnReturn;
    private ImageView imgDetail;
    private TextView tvNameDetail, tvDescriptionDetail, tvPriceDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        imgDetail = (ImageView) findViewById(R.id.imgDetail);
        tvNameDetail = (TextView) findViewById(R.id.tvNameDetail);
        tvDescriptionDetail = (TextView) findViewById(R.id.tvDescriptionDetail);
        tvPriceDetail = (TextView) findViewById(R.id.tvPriceDetail);

        dbHelper = new DBHelper(this);
        productoService = new ProductoService();

        Intent intent = getIntent();

        tvNameDetail.setText(intent.getStringExtra("name"));
        tvDescriptionDetail.setText(intent.getStringExtra("description"));
        tvPriceDetail.setText(String.valueOf(intent.getIntExtra("price", 0)));
        Glide.with(MainActivity3.this)
                .load(intent.getStringExtra("image"))
                .override(500, 500)
                .into(imgDetail);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent2);
            }
        });
    }
}