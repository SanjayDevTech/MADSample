package com.sample.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sample.mad.eigth.AlertMsgActivity;
import com.sample.mad.fifth.DBActivity;
import com.sample.mad.first.MainActivity;
import com.sample.mad.fourth.CanvasActivity;
import com.sample.mad.second.LayoutManagerActivity;
import com.sample.mad.seventh.ImageActivity;
import com.sample.mad.third.CalActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button firstBtn = findViewById(R.id.firstBtn);
        Button secondBtn = findViewById(R.id.secondBtn);
        Button thirdBtn = findViewById(R.id.thirdBtn);
        Button fourthBtn = findViewById(R.id.fourthBtn);
        Button fifthBtn = findViewById(R.id.fifthBtn);
        Button seventhBtn = findViewById(R.id.seventhBtn);
        Button eigthBtn = findViewById(R.id.eigthBtn);
        firstBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
        secondBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, LayoutManagerActivity.class));
        });
        thirdBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, CalActivity.class));
        });
        fourthBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, CanvasActivity.class));
        });
        fifthBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, DBActivity.class));
        });
        seventhBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, ImageActivity.class));
        });
        eigthBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, AlertMsgActivity.class));
        });

    }
}