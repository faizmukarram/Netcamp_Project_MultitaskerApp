package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Tenth extends AppCompatActivity {
    Button b1,b2,b3;
    WifiManager wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tenth);
        b1=(Button)findViewById(R.id.button22);
        b2=(Button)findViewById(R.id.button23);
        b3=(Button)findViewById(R.id.button24);
        wifi=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tenth.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifi.setWifiEnabled(true);
                Toast.makeText(Tenth.this, "Wifi On", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifi.setWifiEnabled(false);
                Toast.makeText(Tenth.this, "Wifi Off", Toast.LENGTH_SHORT).show();
            }
        });
    }
}