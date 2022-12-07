package com.example.projectg103.DB;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.projectg103.Adaptadores.ProductoAdapter;
import com.example.projectg103.Entidades.Producto;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase() {
        this.db =  FirebaseFirestore.getInstance();
    }

    public void insertProduct(String name, String description, String price, byte[] image){
        // Create a new user with a first and last name
        Map<String, Object> product = new HashMap<>();
        product.put("name", name);
        product.put("description", description);
        product.put("price", price);
        //product.put("image", image.);


        // Add a new document with a generated ID
        db.collection("products")
                .add(product)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public void getProducts(ProductoAdapter productoAdapter, ArrayList<Producto> list){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Producto producto = new Producto(
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        Integer.parseInt(document.getData().get("price").toString())
                                );
                                list.add(producto);
                            }
                            productoAdapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void deleteProduct(String id){
        db.collection("products")
                .document(id)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //cualquier cosa
                    }
                });
    }

    public void updateProduct(Producto producto){
        db.collection("Establecimientos")
                .document( String.valueOf(producto.getId()))
                .update(
                        "name",producto.getName(),
                        "description",producto.getDescription(),
                        "price", producto.getPrice()
                )
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //cualquier cosa
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("MainActivity", "Error",e);
                    }
                });
    }
}
