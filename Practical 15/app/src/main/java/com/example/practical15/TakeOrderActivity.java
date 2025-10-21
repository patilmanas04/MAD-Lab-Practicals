package com.example.practical15;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TakeOrderActivity extends AppCompatActivity {

    private EditText editTextPhone, editTextItemName, editTextQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_order);

        editTextPhone = findViewById(R.id.editText_phone);
        editTextItemName = findViewById(R.id.editText_item_name);
        editTextQuantity = findViewById(R.id.editText_quantity);

        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveOrder();
            }
        });
    }

    private void saveOrder() {
        String phone = editTextPhone.getText().toString();
        String itemName = editTextItemName.getText().toString();
        int quantity = Integer.parseInt(editTextQuantity.getText().toString());

        // Initialize your SQLiteOpenHelper (e.g., OrderDatabaseHelper) and get a writable database.
        OrderDatabaseHelper dbHelper = new OrderDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_PHONE, phone);
        values.put(OrderContract.OrderEntry.COLUMN_ITEM_NAME, itemName);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        db.insert(OrderContract.OrderEntry.TABLE_NAME, null, values);

        db.close();
        Toast.makeText(this, "Order saved!", Toast.LENGTH_SHORT).show();
    }
}