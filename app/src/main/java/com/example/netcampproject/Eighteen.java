package com.example.netcampproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Eighteen extends AppCompatActivity {
    Button b1,b2;
    VideoView v1;
    MediaController m1;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_eighteen);
        b1=(Button) findViewById(R.id.button37);
        b2=(Button) findViewById(R.id.button41);
        v1=(VideoView) findViewById(R.id.videoView2);
        m1=new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Eighteen.this, Sixteen.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(j, 20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri=data.getData();
        v1.setVideoURI(uri);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
    }
}