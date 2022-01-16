package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button send;
    EditText name, email, address, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        address = findViewById(R.id.edit_address);
        phone = findViewById(R.id.edit_phone);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                String name2 = name.getText().toString();
                String email2 = email.getText().toString();
                String address2 = address.getText().toString();
                String phone2 = phone.getText().toString();
               Intent i = new Intent(MainActivity2.this, MainActivity.class);
                   Bundle bn = new Bundle();
                bn.putString("name",name2);
                bn.putString("email", email2);
                bn.putString("address",address2);
                bn.putString("phone",phone2);
                i.putExtras(bn);
                startActivity(i);
            }
      });

    }
}