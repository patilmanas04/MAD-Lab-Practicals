package com.example.practical15;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ViewOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        ArrayList<String> orderList = getOrders();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderList);

        ListView listView = findViewById(R.id.listView_orders);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> getOrders() {
        ArrayList<String> orderList = new ArrayList<>();

        OrderDatabaseHelper dbHelper = new OrderDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                OrderContract.OrderEntry.COLUMN_PHONE,
                OrderContract.OrderEntry.COLUMN_ITEM_NAME,
                OrderContract.OrderEntry.COLUMN_QUANTITY
        };

        Cursor cursor = db.query(
                OrderContract.OrderEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(OrderContract.OrderEntry.COLUMN_PHONE));
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(OrderContract.OrderEntry.COLUMN_ITEM_NAME));
            int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(OrderContract.OrderEntry.COLUMN_QUANTITY));

            String order = "Phone: " + phone + ", Item: " + itemName + ", Quantity: " + quantity;
            orderList.add(order);
        }

        cursor.close();
        db.close();

        return orderList;
    }
}