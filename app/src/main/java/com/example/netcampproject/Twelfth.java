package com.example.netcampproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class Twelfth extends AppCompatActivity {
    ToggleButton tb;
    Button b1;
    CameraManager cm;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twelfth);
        b1=(Button)findViewById(R.id.button26);
        tb=(ToggleButton)findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Twelfth.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    try{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1, true);
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
                else
                {
                    try {
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1, false);
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
            }
        });
    }
}