package com.sample.mad.fourth;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.mad.R;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        Bitmap bg = Bitmap.createBitmap(720, 1280,
                Bitmap.Config.ARGB_8888);
        ImageView i = findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg)); //Creating the Canvas Object
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.teal_700));
        paint.setTextSize(50);
        canvas.drawText("Rectangle", 420, 150, paint);
        canvas.drawRect(400, 200, 650, 700, paint);
        canvas.drawText("Circle", 120, 150, paint);
        canvas.drawCircle(200, 350, 150, paint);
        canvas.drawText("Square", 120, 800, paint);
        canvas.drawRect(50, 850, 350, 1150, paint);
        canvas.drawText("Line", 480, 800, paint);
        canvas.drawLine(520, 850, 520, 1150, paint);
    }
}