package com.example.lostfoundapp_224385035;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.Cursor;

// Display all lost and found items in a list
public class ItemListActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        // To initialize database helper for getting data
        dbHelper = new DatabaseHelper(this);

        // Set up recycler view with linear layout
        RecyclerView recyclerView = findViewById(R.id.recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // To create and set adapter for recycler view and load it
        adapter = new ItemAdapter(this, dbHelper);
        recyclerView.setAdapter(adapter);
        loadItems();
    }

    // To load all items from database
    private void loadItems() {
        Cursor cursor = dbHelper.getAllItems();
        adapter.swapCursor(cursor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadItems();
    }
} 