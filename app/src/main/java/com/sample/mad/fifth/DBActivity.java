package com.sample.mad.fifth;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sample.mad.R;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class DBActivity extends AppCompatActivity {
    private EditText nameEdit;
    private EditText descEdit;

    private AppDatabase db;
    private TopicDAO dao;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        db = AppDatabase.getInstance(this);
        dao = db.topicDao();
        nameEdit = findViewById(R.id.nameEdit);
        descEdit = findViewById(R.id.descEdit);

        Button insertBtn = findViewById(R.id.insertBtn);
        Button updateBtn = findViewById(R.id.updateBtn);
        Button deleteBtn = findViewById(R.id.deleteBtn);
        Button clearBtn = findViewById(R.id.clearBtn);
        Button readBtn = findViewById(R.id.readBtn);

        readBtn.setOnClickListener((v) -> {
            String title = nameEdit.getText().toString();
            if (title.isEmpty()) {
                Toast.makeText(this, "Empty title", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    Topic topic = dao.select(title);
                    if (topic != null) {
                        descEdit.setText(topic.getDescription());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        insertBtn.setOnClickListener((v) -> {

            String title = nameEdit.getText().toString();
            String desc = descEdit.getText().toString();
            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show();
            } else {
                Topic topic = new Topic(title, desc);
                nameEdit.getText().clear();
                descEdit.getText().clear();
                try {
                    dao.insert(topic);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        updateBtn.setOnClickListener(v -> {
            String title = nameEdit.getText().toString();
            String desc = descEdit.getText().toString();
            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show();
            } else {
                Topic topic = new Topic(title, desc);
                nameEdit.getText().clear();
                descEdit.getText().clear();
                try {
                    dao.update(topic);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        deleteBtn.setOnClickListener((v) -> {
            String title = nameEdit.getText().toString();
            if (title.isEmpty()) {
                Toast.makeText(this, "Need title", Toast.LENGTH_SHORT).show();
            } else {
                nameEdit.getText().clear();
                descEdit.getText().clear();
                try {
                    dao.delete(title);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        clearBtn.setOnClickListener((v) -> {
            try {
                dao.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}