package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TwentyOne extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty_one);
        b1=(Button) findViewById(R.id.button48);
        b2=(Button) findViewById(R.id.button51);
        e1=(EditText)findViewById(R.id.editTextTextPersonName10);
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate(0.9f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TwentyOne.this, Nineteen.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                if(s1.equals(""))
                {
                    Toast.makeText(TwentyOne.this, "Please Fill", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    tts.speak(s1, TextToSpeech.QUEUE_FLUSH, null);
                    e1.setText("");
                }
            }
        });

    }
}