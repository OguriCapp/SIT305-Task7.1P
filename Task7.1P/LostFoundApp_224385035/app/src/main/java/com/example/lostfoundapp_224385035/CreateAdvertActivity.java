package com.example.lostfoundapp_224385035;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// To create new lost or found item advert and allow users to input item details and save to database
public class CreateAdvertActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        // Initialize database helper for saving data
        dbHelper = new DatabaseHelper(this);

        // To get all input fields from layout
        RadioGroup radioGroupType = findViewById(R.id.radioGroupType);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextDescription = findViewById(R.id.editTextDescription);
        EditText editTextDate = findViewById(R.id.editTextDate);
        EditText editTextLocation = findViewById(R.id.editTextLocation);
        Button btnSave = findViewById(R.id.btnSave);

        // To handle save button click
        btnSave.setOnClickListener(v -> {
            // To define and get all input values
            String type = radioGroupType.getCheckedRadioButtonId() == R.id.radioLost ? "Lost" : "Found";
            String name = editTextName.getText().toString();
            String phone = editTextPhone.getText().toString();
            String description = editTextDescription.getText().toString();
            String date = editTextDate.getText().toString();
            String location = editTextLocation.getText().toString();

            // To check if all fields are filled
            if (name.isEmpty() || phone.isEmpty() || description.isEmpty() || date.isEmpty() || location.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // To save data to database
            long result = dbHelper.insertItem(type, name, phone, description, date, location);
            if (result != -1) {
                Toast.makeText(this, "Item saved successfully", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error saving item", Toast.LENGTH_SHORT).show();
            }
        });
    }
} 