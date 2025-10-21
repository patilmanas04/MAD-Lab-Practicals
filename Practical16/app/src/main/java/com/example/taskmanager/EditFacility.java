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

public class EditFacility extends AppCompatActivity {

    EditText title, description;
    TextView topic;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_facility);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        topic = findViewById(R.id.topic);
        submit = findViewById(R.id.Submit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        topic.setText("Edit your note");

        title.setText(getIntent().getStringExtra("title"));
        description.setText(getIntent().getStringExtra("description"));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().isEmpty()) {
                    Toast.makeText(EditFacility.this, "Empty title ??", Toast.LENGTH_SHORT).show();
                } else {
                    SQLHandler sqlHandler = new SQLHandler(EditFacility.this, "MyDB", null, 1);
                    sqlHandler.Edit(title.getText().toString(), getIntent().getStringExtra("title") ,description.getText().toString(), getIntent().getStringExtra("description"),getIntent().getStringExtra("date"));
                    Toast.makeText(EditFacility.this, "Note Updated Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
