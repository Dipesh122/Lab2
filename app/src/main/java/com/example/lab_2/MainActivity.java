package com.example.lab_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button get_image, get_detail;
    TextView tv_name, tv_email, tv_phone, tv_address;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        get_image = findViewById(R.id.get_image);
        get_detail = findViewById(R.id.get_detail);
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_phone = findViewById(R.id.tv_phone);
        tv_address = findViewById(R.id.tv_address);

        get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent image = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(image,10);
            }
        });

        get_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name","a");
        String address = bundle.getString("address","b");
        String email = bundle.getString("email","c");
        String phone = bundle.getString("phone","d");


        tv_name.setText("Name: " +name);
        tv_address.setText("Address: "+address);
        tv_email.setText("Email: "+email);
        tv_phone.setText("Phone: "+phone);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            Bundle b = data.getExtras();
            Bitmap bmp = (Bitmap) b.get("data");
            image.setImageBitmap(bmp);
        }
    }
}