package com.example.taskmanager.modules;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.practical14.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ShowNote extends BottomSheetDialogFragment {

    String title, body, date;

    public ShowNote(String title, String body, String date) {
        this.body = body;
        this.title = title;
        this.date = date;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_notes, null);
        TextView titleView = view.findViewById(R.id.title);
        TextView bodyView = view.findViewById(R.id.body);
        TextView dateView = view.findViewById(R.id.date);
        

        titleView.setText(title);
        bodyView.setText(body);
        dateView.setText(date);
        return view;
    }
}
