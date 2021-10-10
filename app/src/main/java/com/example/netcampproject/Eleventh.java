package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Eleventh extends AppCompatActivity {
    Button b1;
    ImageView i1;
    BluetoothAdapter ba;
    private boolean blue=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_eleventh);
        b1=(Button)findViewById(R.id.button25);
        i1=(ImageView) findViewById(R.id.imageView14);
        ba=BluetoothAdapter.getDefaultAdapter();
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blue==false)
                {
                    ba.enable();
                    blue=true;
                    i1.setImageResource(R.drawable.on);
                }
                else
                {
                    ba.disable();
                    blue=false;
                    i1.setImageResource(R.drawable.off);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Eleventh.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });
    }
}