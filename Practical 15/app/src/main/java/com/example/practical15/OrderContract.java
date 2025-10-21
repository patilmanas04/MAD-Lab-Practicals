package com.example.practical15;

import android.provider.BaseColumns;

public final class OrderContract {

    private OrderContract() {}

    public static class OrderEntry implements BaseColumns {
        public static final String TABLE_NAME = "orders";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ITEM_NAME = "item_name";
        public static final String COLUMN_QUANTITY = "quantity";
    }
}