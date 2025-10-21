package com.example.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practical14.R;
import com.example.taskmanager.modules.SQLHandler;

public class AddFacility extends AppCompatActivity {

    TextView topic;
    EditText title, description;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_facility);

        topic = findViewById(R.id.topic);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        submit = findViewById(R.id.Submit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        topic.setText("Add a Note");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().isEmpty()) {
                    Toast.makeText(AddFacility.this, "Empty title ??", Toast.LENGTH_SHORT).show();
                } else {
                    SQLHandler sqlHandler = new SQLHandler(AddFacility.this, "MyDB", null, 1);
                    sqlHandler.Insert(title.getText().toString(), description.getText().toString());
                    Toast.makeText(AddFacility.this, "Note Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
