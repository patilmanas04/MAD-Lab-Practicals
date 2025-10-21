package com.example.practical3;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView name, password, email, phone, country, state, interests;
    private Button submitButton, datePickerBtn;
    private RadioButton maleRadioBtn, femaleRadioBtn;

    public static final String EXTRA_NAME = "com.example.practical3.EXTRA_NAME";
    public static final String EXTRA_PASSWORD = "com.example.practical3.EXTRA_PASSWORD";
    public static final String EXTRA_EMAIL = "com.example.practical3.EXTRA_EMAIL";
    public static final String EXTRA_PHONE = "com.example.practical3.EXTRA_PHONE";
    public static final String EXTRA_COUNTRY = "com.example.practical3.EXTRA_COUNTRY";
    public static final String EXTRA_STATE = "com.example.practical3.EXTRA_STATE";
    public static final String EXTRA_GENDER = "com.example.practical3.EXTRA_GENDER";
    public static final String EXTRA_INTERESTS = "com.example.practical3.EXTRA_INTERESTS";
    public static final String EXTRA_BIRTHDATE = "com.example.practical3.EXTRA_BIRTHDATE";
    public static String gender = "";
    public static String birthDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        maleRadioBtn = findViewById(R.id.male);
        femaleRadioBtn = findViewById(R.id.female);
        interests = findViewById(R.id.interests);
        datePickerBtn = findViewById(R.id.datePickerBtn);
        submitButton = findViewById(R.id.submitButton);

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calender = Calendar.getInstance();

                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        birthDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String passwordText = password.getText().toString();
                String emailText = email.getText().toString();
                String phoneText = phone.getText().toString();
                String countryText = country.getText().toString();
                String stateText = state.getText().toString();
                String genderText = gender;
                String interestsText = interests.getText().toString();
                String birthDateText = birthDate;

                Intent intent = new Intent(getBaseContext(), MainActivity2.class);
                intent.putExtra(EXTRA_NAME, userName);
                intent.putExtra(EXTRA_PASSWORD, passwordText);
                intent.putExtra(EXTRA_EMAIL, emailText);
                intent.putExtra(EXTRA_PHONE, phoneText);
                intent.putExtra(EXTRA_COUNTRY, countryText);
                intent.putExtra(EXTRA_STATE, stateText);
                intent.putExtra(EXTRA_GENDER, genderText);
                intent.putExtra(EXTRA_INTERESTS, interestsText);
                intent.putExtra(EXTRA_BIRTHDATE, birthDateText);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        int id = view.getId();
        if(id==R.id.male){
            if(checked){
                gender = ((RadioButton) view).getText().toString();
            }
        }
        else if(id==R.id.female){
            if(checked){
                gender = ((RadioButton) view).getText().toString();
            }
        }
    }
}