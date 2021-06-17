package com.example.gymapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText name_input, email_input, location_input, password_input, repeatpassword_input;
    Button update_button;

    String id, name, email, location , password, repeatpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.et_first_name);
        email_input = findViewById(R.id.et_email);
        location_input = findViewById(R.id.et_location);
        password_input = findViewById(R.id.et_password);
        repeatpassword_input = findViewById(R.id.et_repeat_password);
        update_button = findViewById(R.id.update_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                name = name_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                location = location_input.getText().toString().trim();
                password = password_input.getText().toString().trim();
                repeatpassword = repeatpassword_input.getText().toString().trim();
                myDB.updateData(id, name, email, location, password, repeatpassword);
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("email") && getIntent().hasExtra("location") && getIntent().hasExtra("password") && getIntent().hasExtra("repeat password")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            email = getIntent().getStringExtra("email");
            location = getIntent().getStringExtra("location");
            password = getIntent().getStringExtra("password");
            repeatpassword = getIntent().getStringExtra("repeat password");

            //Setting Intent Data
            name_input.setText(name);
            email_input.setText(email);
            location_input.setText(location);
            password_input.setText(password);
            repeatpassword_input.setText(repeatpassword);
            Log.d("zinzi", name+" "+email+" "+location+" "+password+" "+repeatpassword);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}
