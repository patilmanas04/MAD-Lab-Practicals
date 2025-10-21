package com.example.practical12;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView textViewWelcome = findViewById(R.id.textViewWelcome);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        if (email != null) {
            textViewWelcome.setText("Welcome, " + email + "!");
        }
    }
}