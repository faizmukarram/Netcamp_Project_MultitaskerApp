package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class TwentyThree extends AppCompatActivity {
    Button b1,b2;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_three);
        b1=(Button) findViewById(R.id.button50);
        e1=(EditText)findViewById(R.id.editTextTextPersonName11);
        b2=(Button) findViewById(R.id.button53);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TwentyThree.this, Nineteen.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                Intent j=new Intent(getApplicationContext(), TwentyFour.class);
                j.putExtra("myname", s1);
                startActivity(j);
            }
        });
    }
}