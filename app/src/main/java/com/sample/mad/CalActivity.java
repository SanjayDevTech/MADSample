package com.sample.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText crunchifyEditText;
    float mValueOne, mValueTwo;

    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        buttonAdd = findViewById(R.id.buttonadd);
        buttonSub = findViewById(R.id.buttonsub);
        buttonMul = findViewById(R.id.buttonmul);
        buttonDivision = findViewById(R.id.buttondiv);
        buttonC = findViewById(R.id.buttonC);
        buttonEqual = findViewById(R.id.buttoneql);
        crunchifyEditText = findViewById(R.id.edt1);
        button1.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "1"));

        button2.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "2"));

        button3.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "3"));

        button4.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "4"));

        button5.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "5"));

        button6.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "6"));

        button7.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "7"));

        button8.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "8"));

        button9.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "9"));

        button0.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "0"));

        buttonAdd.setOnClickListener(v -> {
            if (crunchifyEditText != null) {
                mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
                crunchifyAddition = true;
                crunchifyEditText.setText(null);
            }
        });

        buttonSub.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            mSubtract = true;
            crunchifyEditText.setText(null);
        });

        buttonMul.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            crunchifyMultiplication = true;
            crunchifyEditText.setText(null);
        });

        buttonDivision.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            crunchifyDivision = true;
            crunchifyEditText.setText(null);
        });

        buttonEqual.setOnClickListener(v -> {
            mValueTwo = Float.parseFloat(crunchifyEditText.getText() + "");

            if (crunchifyAddition) {
                crunchifyEditText.setText(mValueOne + mValueTwo + "");
                crunchifyAddition = false;
            }

            if (mSubtract) {
                crunchifyEditText.setText(mValueOne - mValueTwo + "");
                mSubtract = false;
            }

            if (crunchifyMultiplication) {
                crunchifyEditText.setText(mValueOne * mValueTwo + "");
                crunchifyMultiplication = false;
            }

            if (crunchifyDivision) {
                crunchifyEditText.setText(mValueOne / mValueTwo + "");
                crunchifyDivision = false;
            }
        });

        buttonC.setOnClickListener(v -> crunchifyEditText.setText(""));

        button10.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "."));
    }
}