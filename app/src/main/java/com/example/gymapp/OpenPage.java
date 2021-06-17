package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OpenPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);
    }

    public void goLogin(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}