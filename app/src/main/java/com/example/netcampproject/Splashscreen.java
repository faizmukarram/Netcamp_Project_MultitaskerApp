package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        Thread thread =new Thread(){
            public void run(){
                try {
                    sleep(1500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent i=new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };thread.start();
    }
}