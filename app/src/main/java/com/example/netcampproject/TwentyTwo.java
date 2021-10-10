package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TwentyTwo extends AppCompatActivity {
    Button b1,b2;
    Vibrator v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_two);
        b1=(Button) findViewById(R.id.button49);
        b2=(Button) findViewById(R.id.button52);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TwentyTwo.this, Nineteen.class);
                startActivity(i);
                finish();
                v1.cancel();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>26)
                {
                    v1.vibrate(9000);
                }
                else
                {
                    v1.vibrate(9000);
                }
            }
        });
    }
}