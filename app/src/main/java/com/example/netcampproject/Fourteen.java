package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fourteen extends AppCompatActivity {
    Button b1;
    ImageView im;
    MediaPlayer mp1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fourteen);
        b1=(Button) findViewById(R.id.button33);
        im=(ImageView)findViewById(R.id.imageView13);
        t1=(TextView) findViewById(R.id.textView28);
        mp1=MediaPlayer.create(this, R.raw.vs);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fourteen.this, Thirteen.class);
                startActivity(i);
                mp1.stop();
                finish();
            }
        });
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setSelected(true);
                if (mp1.isPlaying())
                {
                    mp1.pause();
                    im.setImageResource(R.drawable.play);
                }
                else
                {
                    mp1.start();
                    im.setImageResource(R.drawable.pause);
                }
            }
        });
    }
}