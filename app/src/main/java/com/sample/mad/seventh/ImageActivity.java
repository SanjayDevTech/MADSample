
package com.sample.mad.seventh;

import static android.Manifest.permission.CAMERA;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.sample.mad.R;

public class ImageActivity extends AppCompatActivity {
    private ImageView imageView;

    private final ActivityResultLauncher<String> captureImage = registerForActivityResult(new ActivityResultContract<String, Bitmap>() {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String input) {
            return new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        }

        @Override
        public Bitmap parseResult(int resultCode, @Nullable Intent intent) {
            return (Bitmap) intent.getExtras().get("data");
        }
    }, photo -> {
        imageView.setImageBitmap(photo);
    });

    private final ActivityResultLauncher<String> requestCameraPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            captureImage.launch("");
        } else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Button buttonCapture = findViewById(R.id.insertBtn);
        imageView = findViewById(R.id.imageView);

        buttonCapture.setOnClickListener((v) -> {
            requestCameraPermission.launch(CAMERA);
        });
    }
}