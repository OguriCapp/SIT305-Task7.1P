package com.example.lostfoundapp_224385035;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// To show the main screen of the app
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To get buttons from layout
        Button btnCreateNewAdvert = findViewById(R.id.btnCreateNewAdvert);
        Button btnShowAllItems = findViewById(R.id.btnShowAllItems);

        // To handle create new advert button click
        btnCreateNewAdvert.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateAdvertActivity.class);
            startActivity(intent);
        });

        // To handle show all items button click
        btnShowAllItems.setOnClickListener(v -> {
            Intent intent = new Intent(this, ItemListActivity.class);
            startActivity(intent);
        });
    }
}