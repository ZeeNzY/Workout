package com.example.gymapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText name_input, email_input, location_input, password_input, repeatpassword_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.et_first_name);
        name_input = findViewById(R.id.et_email);
        location_input = findViewById(R.id.et_location);
        password_input = findViewById(R.id.et_password);
        repeatpassword_input = findViewById(R.id.et_repeat_password);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.jovanovic.stefan.sqlitetutorial.MyDatabaseHelper myDB = new com.jovanovic.stefan.sqlitetutorial.MyDatabaseHelper(com.jovanovic.stefan.sqlitetutorial.AddActivity.this);
                myDB.addBook(name_input.getText().toString().trim(),
                        email_input.getText().toString().trim(),
                        location_input.getText().toString().trim(),
                        password_input.getText().toString().trim(),
                        repeatpassword_input.getText().toString().trim());
            }
        });
    }
}
