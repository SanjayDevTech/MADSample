package com.sample.mad.fifth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sample.mad.R;

public class DBActivity extends AppCompatActivity {
    private EditText editTextID;
    private EditText editTextName;

    private String name;
    private int number;
    private String ID;

    private DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        db = new DBHelper(this);  // to call constructor

        editTextID = findViewById(R.id.editText1);
        editTextName = findViewById(R.id.editText2);

        Button buttonSave = findViewById(R.id.button);
        Button buttonRead = findViewById(R.id.button2);
        Button buttonUpdate = findViewById(R.id.button3);
        Button buttonDelete = findViewById(R.id.button4);
        Button buttonSearch = findViewById(R.id.button5);
        Button buttonDeleteAll = findViewById(R.id.button6);

        buttonSave.setOnClickListener((v)-> {

                name = editTextName.getText().toString();



                if (name.isEmpty() ) {

                    Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show();
                } else {


                    try {
                        // Insert Data
                        db.insertData(name);

                        // Clear the fields
                        editTextID.getText().clear();
                        editTextName.getText().clear();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


        });



        buttonUpdate.setOnClickListener(v ->{

                name = editTextName.getText().toString();
                ID = editTextID.getText().toString();

                if (name.isEmpty()|| ID.isEmpty()) {

                    Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show();
                } else {


                    try {
                        // Update Data
                        db.updateData(ID, name);

                        // Clear the fields
                        editTextID.getText().clear();
                        editTextName.getText().clear();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        buttonDelete.setOnClickListener((v) -> {

                ID = editTextID.getText().toString();

                if (ID.isEmpty()) {

                    Toast.makeText(this, "Please enter the ID", Toast.LENGTH_SHORT).show();
                } else {

                    try {
                        // Delete Data
                        db.deleteData(ID);

                        // Clear the fields
                        editTextID.getText().clear();
                        editTextName.getText().clear();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }



        });

        buttonDeleteAll.setOnClickListener((v) -> {

                // Delete all data
                // simply delete all the data by calling this method --> db.deleteAllData();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("Delete All Data");
                builder.setCancelable(false);
                builder.setMessage("Do you really need to delete your all data ?");
                builder.setPositiveButton("Yes", (dialog, which) -> {

                    // User confirmed , now you can delete the data
                    db.deleteAllData();

                    // Clear the fields
                    editTextID.getText().clear();
                    editTextName.getText().clear();
                });
                builder.setNegativeButton("No", (dialog, which) -> {

                    // user not confirmed
                    dialog.cancel();
                });

                AlertDialog dialog = builder.create();
                dialog.show();


        });

    }
}