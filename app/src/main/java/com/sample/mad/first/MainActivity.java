package com.sample.mad.first;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.sample.mad.R;

/**
 * First exp
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private float size = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button incBtn = findViewById(R.id.incBtn);
        Button decBtn = findViewById(R.id.decBtn);
        Button redBtn = findViewById(R.id.redBtn);
        Button blueBtn = findViewById(R.id.blueBtn);
        Button greenBtn = findViewById(R.id.greenBtn);
        EditText editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                textView.setText(s.toString());
            }
        });

        incBtn.setOnClickListener((v) -> {
            size+=4;
            textView.setTextSize(size);
        });
        decBtn.setOnClickListener((v) -> {
            if (size <= 0) return;
            size-=4;
            textView.setTextSize(size);
        });
        redBtn.setOnClickListener((v) -> {
            textView.setTextColor(0xFFFF0000);
        });
        blueBtn.setOnClickListener((v) -> {
            textView.setTextColor(0xFF0000FF);
        });
        greenBtn.setOnClickListener((v) -> {
            textView.setTextColor(0xFF00FF00);
        });
    }
}