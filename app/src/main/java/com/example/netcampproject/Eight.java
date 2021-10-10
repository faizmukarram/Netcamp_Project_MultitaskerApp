package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Eight extends AppCompatActivity {
    Button b1;
    ImageButton ib;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_eight);
        ib=(ImageButton)findViewById(R.id.imageButton);
        b1=(Button)findViewById(R.id.button17);
        e1=(EditText)findViewById(R.id.editTextTextPersonName7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Eight.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });

        ActivityCompat.requestPermissions(Eight.this, new String[]{Manifest.permission.CALL_PHONE}, PackageManager.PERMISSION_GRANTED);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();

                if (s1.isEmpty())
                {
                    Toast.makeText(Eight.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent j=new Intent(Intent.ACTION_CALL);
                    j.setData(Uri.parse("tel:"+s1));
                    startActivity(j);
                    e1.setText("");
                }
            }
        });
    }
}