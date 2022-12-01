package com.example.projectg103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.projectg103.DB.DBHelper;

import java.nio.charset.StandardCharsets;

public class FormProduct extends AppCompatActivity {
    private Button btnFormProduct;
    private EditText editNameFormProduct, editDescriptionFormProduct, editPriceFormProduct;
    private ImageView imgFormProduct;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_product);

        btnFormProduct = (Button) findViewById(R.id.btnFormProduct);
        editNameFormProduct = (EditText) findViewById(R.id.editNameFormProduct);
        editDescriptionFormProduct = (EditText) findViewById(R.id.editDescriptionFormProduct);
        editPriceFormProduct = (EditText) findViewById(R.id.editPriceFormProduct);
        imgFormProduct = (ImageView) findViewById(R.id.imgFormProduct);
        byte[] img = "".getBytes(StandardCharsets.UTF_8);
        try {
            dbHelper = new DBHelper(this);
        }catch (Exception e){
            Log.e("DB", e.toString());
        }

        btnFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbHelper.insertProduct(
                        editNameFormProduct.getText().toString(),
                        editDescriptionFormProduct.getText().toString(),
                        editPriceFormProduct.getText().toString(),
                        img);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}