package com.example.practical11;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNo1, etNo2;
    private TextView tvResult;
    private int selectedOperation = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNo1 = findViewById(R.id.etNo1);
        etNo2 = findViewById(R.id.etNo2);
        tvResult = findViewById(R.id.tvResult);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        String num1Str = etNo1.getText().toString();
        String num2Str = etNo2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            tvResult.setText("Please enter both numbers.");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        double result = 0.0; // Initialize the result

        if (selectedOperation == R.id.menu_addition) {
            result = num1 + num2;
        } else if (selectedOperation == R.id.menu_subtraction) {
            result = num1 - num2;
        } else if (selectedOperation == R.id.menu_multiplication) {
            result = num1 * num2;
        } else {
            tvResult.setText("Please select an operation from the menu.");
            return;
        }

        tvResult.setText("Result: " + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        selectedOperation = item.getItemId();
        calculateResult(); // Recalculate on menu item selection
        return true;
    }
}