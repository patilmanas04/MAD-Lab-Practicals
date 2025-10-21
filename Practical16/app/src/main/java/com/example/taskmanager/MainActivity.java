package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practical14.R;
import com.example.taskmanager.modules.NotesAdapter;
import com.example.taskmanager.modules.SQLHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    SQLHandler sqlHandler;
    FloatingActionButton floatingActionButton;
    RecyclerView notesList;
    NotesAdapter notesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqlHandler = new SQLHandler(this, "MyDB",null, 1);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.newNote);
        notesList = findViewById(R.id.recyclerView);
        notesList.setLayoutManager(new LinearLayoutManager(this));
        notesListAdapter = new NotesAdapter(sqlHandler, MainActivity.this, getSupportFragmentManager());
        notesList.setAdapter(notesListAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddFacility.class));
            }
        });

        notesListAdapter.sync();

    }
}