package com.example.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView name, password, email, phone, country, state, gender, interests, birthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        gender = findViewById(R.id.gender);
        interests = findViewById(R.id.interests);
        birthDate = findViewById(R.id.date);

        Intent intent = getIntent();
        String nameText = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String passwordText = intent.getStringExtra(MainActivity.EXTRA_PASSWORD);
        String emailText = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        String phoneText = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        String countryText = intent.getStringExtra(MainActivity.EXTRA_COUNTRY);
        String stateText = intent.getStringExtra(MainActivity.EXTRA_STATE);
        String genderText = intent.getStringExtra(MainActivity.EXTRA_GENDER);
        String interestsText = intent.getStringExtra(MainActivity.EXTRA_INTERESTS);
        String birthDateText = intent.getStringExtra(MainActivity.EXTRA_BIRTHDATE);

        name.setText(nameText);
        password.setText(passwordText);
        email.setText(emailText);
        phone.setText(phoneText);
        country.setText(countryText);
        state.setText(stateText);
        gender.setText(genderText);
        interests.setText(interestsText);
        birthDate.setText(birthDateText);
    }
}