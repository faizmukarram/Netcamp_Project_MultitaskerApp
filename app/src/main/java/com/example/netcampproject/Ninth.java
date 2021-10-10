package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ninth extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ninth);
        e1=(EditText)findViewById(R.id.editTextTextPersonName8);
        e2=(EditText)findViewById(R.id.editTextTextPersonName9);
        b1=(Button)findViewById(R.id.button16);
        b2=(Button)findViewById(R.id.button18);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ninth.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });

        ActivityCompat.requestPermissions(Ninth.this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();

                if (s1.isEmpty())
                {
                    Toast.makeText(Ninth.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (s2.isEmpty())
                    {
                        Toast.makeText(Ninth.this, "Please Fill Message Box", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (s1!=null)
                        {
                            SmsManager smsManager=SmsManager.getDefault();
                            smsManager.sendTextMessage(s1, null,s2, null, null);

                            Toast.makeText(Ninth.this, "Message Sent Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(Ninth.this, "Message Sent Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}