package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Twenty extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
    EditText e1;
    boolean Add, Sub, Mul, Div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_twenty);
        b1=(Button) findViewById(R.id.button47);
        b2=(Button)findViewById(R.id.button58);
        b3=(Button)findViewById(R.id.button59);
        b4=(Button)findViewById(R.id.button60);
        b5=(Button)findViewById(R.id.button61);
        b6=(Button)findViewById(R.id.button62);
        b7=(Button)findViewById(R.id.button63);
        b8=(Button)findViewById(R.id.button64);
        b9=(Button)findViewById(R.id.button65);
        b10=(Button)findViewById(R.id.button66);
        b11=(Button)findViewById(R.id.button67);
        b12=(Button)findViewById(R.id.button68);
        b13=(Button)findViewById(R.id.button69);
        b14=(Button)findViewById(R.id.button70);
        b15=(Button)findViewById(R.id.button71);
        b16=(Button)findViewById(R.id.button72);
        b17=(Button)findViewById(R.id.button73);
        b18=(Button)findViewById(R.id.button75);
        e1=(EditText)findViewById(R.id.editTextTextPersonName12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Twenty.this, Nineteen.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "1");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "2");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "3");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "4");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "5");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "6");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "7");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "8");
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "9");
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + ".");
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "0");
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "+");
                Add=true;
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "-");
                Sub=true;
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "*");
                Mul=true;
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "/");
                Div=true;
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                if (Add)
                {
                    String[] arr=s1.split("\\+");
                    String s2=arr[0];
                    String s3=arr[1];
                    Float f1=Float.parseFloat(s2);
                    Float f2=Float.parseFloat(s3);
                    Float f3=f1+f2;
                    String s4=f3.toString();
                    e1.setText(s4);
                    Add=false;
                }
                if (Sub)
                {
                    String[] arr1=s1.split("-");
                    String s5=arr1[0];
                    String s6=arr1[1];
                    Float f4=Float.parseFloat(s5);
                    Float f5=Float.parseFloat(s6);
                    Float f6=f4-f5;
                    String s7=f6.toString();
                    e1.setText(s7);
                    Sub=false;
                }
                if (Mul)
                {
                    String[] arr2=s1.split("\\*");
                    String s8=arr2[0];
                    String s9=arr2[1];
                    Float f7=Float.parseFloat(s8);
                    Float f8=Float.parseFloat(s9);
                    Float f9=f7*f8;
                    String s10=f9.toString();
                    e1.setText(s10);
                    Mul=false;
                }
                if (Div)
                {
                    String[] arr3=s1.split("/");
                    String s11=arr3[0];
                    String s12=arr3[1];
                    Float f10=Float.parseFloat(s11);
                    Float f11=Float.parseFloat(s12);
                    Float f12=f10/f11;
                    String s13=f12.toString();
                    e1.setText(s13);
                    Div=false;
                }
            }
        });
    }
}