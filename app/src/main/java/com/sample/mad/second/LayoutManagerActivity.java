package com.sample.mad.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sample.mad.R;

/**
 * Second exp
 */
public class LayoutManagerActivity extends AppCompatActivity {
    private EditText nameEdit, ageEdit, clgEdit;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_manager);
        nameEdit = findViewById(R.id.nameEdit);
        ageEdit = findViewById(R.id.ageEdit);
        clgEdit = findViewById(R.id.clgEdit);
        submitBtn = findViewById(R.id.button);
        submitBtn.setOnClickListener((v) -> {
            String name = nameEdit.getText().toString();
            String age = ageEdit.getText().toString();
            String clg = clgEdit.getText().toString();
            String message = "Name: "+name+"\nAge: "+age+"\nCollege: "+clg;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }
}