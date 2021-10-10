package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Fifteen extends AppCompatActivity {
    Button b1;
    VideoView v1;
    MediaController m1;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fifteen);
        b1=(Button) findViewById(R.id.button34);
        v1=(VideoView)findViewById(R.id.videoView);
        m1=new MediaController(this);
        uri=Uri.parse("android.resource://" +getPackageName()+ "/" + R.raw.v2);
        v1.setVideoURI(uri);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifteen.this, Thirteen.class);
                startActivity(i);
                finish();
            }
        });
    }
}