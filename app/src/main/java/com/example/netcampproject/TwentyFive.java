package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

public class TwentyFive extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_five);
        b1=(Button) findViewById(R.id.button55);
        r1=(RadioButton) findViewById(R.id.radioButton5);
        r2=(RadioButton) findViewById(R.id.radioButton6);
        r3=(RadioButton) findViewById(R.id.radioButton7);
        r4=(RadioButton) findViewById(R.id.radioButton8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.isChecked())
                {
                    ++TwentyFour.score;
                }
                else
                {
                    --TwentyFour.score;
                }
                Intent i=new Intent(TwentyFive.this, TwentySix.class);
                startActivity(i);
                finish();
            }
        });
    }
}