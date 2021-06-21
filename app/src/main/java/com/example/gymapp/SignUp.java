package com.example.gymapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText name, email, location, password, repeatpassword;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.et_first_name);
        email = findViewById(R.id.et_email);
        location = findViewById(R.id.et_location);
        password = findViewById(R.id.et_password);
        repeatpassword = findViewById(R.id.et_repeat_password);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ClientModel clientModel = new ClientModel(name.getText().toString(),
                            email.getText().toString(),
                            location.getText().toString(),
                            password.getText().toString(),
                            repeatpassword.getText().toString());

                    Toast.makeText(SignUp.this, clientModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(SignUp.this, "Error Creating client", Toast.LENGTH_SHORT).show();
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(SignUp.this);

            }
        });
    }

    /***  add_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
    MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
    myDB.addMember(name_input.getText().toString().trim(),
    email_input.getText().toString().trim(),
    location_input.getText().toString().trim(),
    password_input.getText().toString().trim(),
    repeatpassword_input.getText().toString().trim());
    }
    });
     **/
}
