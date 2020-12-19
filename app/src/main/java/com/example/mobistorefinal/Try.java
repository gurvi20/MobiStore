package com.example.mobistorefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class Try extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;
    private Product productInfo;
    DatabaseReference databasePlayers;
    ArrayList<String> productNames,productImages,productBrandName,price,rating;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        databasePlayers= FirebaseDatabase.getInstance().getReference().child("products");
        recyclerView = findViewById(R.id.name);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productNames= new ArrayList<String>();
        productBrandName = new ArrayList<String>();
        price= new ArrayList<String>();
        rating = new ArrayList<String>();
        productImages= new ArrayList<String>();
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    productInfo = postSnapshot.getValue(Product.class);
                    productNames.add(productInfo.name);
                    productBrandName.add(productInfo.BrandName);
                    price.add(String.valueOf(productInfo.Price));
                    rating.add(String.valueOf(productInfo.rating));
                    productImages.add(productInfo.imagePath);

                }
                adapter = new MyRecyclerViewAdapter(getApplicationContext(), productNames,productBrandName,price,rating,productImages);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        };
        databasePlayers.addListenerForSingleValueEvent(eventListener);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}