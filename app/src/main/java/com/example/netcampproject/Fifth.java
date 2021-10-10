package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class Fifth extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fifth);
        b1=(Button)findViewById(R.id.button8);
        b2=(Button)findViewById(R.id.button10);
        e1=(EditText)findViewById(R.id.editTextTextPersonName5);
        countryCodePicker=(CountryCodePicker)findViewById(R.id.ccp);
        countryCodePicker.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty())
                {
                    Toast.makeText(Fifth.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i=new Intent(Fifth.this, Sixth.class);
                    i.putExtra("mobile", countryCodePicker.getFullNumberWithPlus().trim());
                    startActivity(i);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Fifth.this, Second.class);
                startActivity(j);
                finish();
            }
        });
    }
}