package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class TwentyFour extends AppCompatActivity {
    TextView t1;
    RadioButton r1,r2,r3,r4;
    Button b1;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_four);
        b1=(Button)findViewById(R.id.button54);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        t1=(TextView) findViewById(R.id.textView37);
        Intent i=getIntent();
        String s1=i.getStringExtra("myname");

        if (s1.trim().equals(""))
        {
            t1.setText("Hello User");
        }
        else
        {
            t1.setText("Hello " + s1 );
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                if (r3.isChecked())
                {
                    ++score;
                }
                else
                {
                    --score;
                }
                Intent i=new Intent(TwentyFour.this, TwentyFive.class);
                startActivity(i);
                finish();
            }
        });
    }
}