package com.example.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Sixth extends AppCompatActivity {
    EditText e1;
    Button b1;
    String phone;
    String otp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sixth);
        e1=(EditText)findViewById(R.id.editTextTextPersonName6);
        b1=(Button)findViewById(R.id.button9);
        firebaseAuth=FirebaseAuth.getInstance();
        phone=getIntent().getStringExtra("mobile").toString();
        genotp();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                if (s1.isEmpty())
                {
                    Toast.makeText(Sixth.this, "Fill OTP", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (s1.length()!=6)
                    {
                        Toast.makeText(Sixth.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp, s1);
                        signInWithPhoneAuthCredential(credential);
                    }
                }
            }
        });

    }private void genotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @org.jetbrains.annotations.NotNull String s, @NonNull @org.jetbrains.annotations.NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
                        Toast.makeText(Sixth.this, "OTP Mismatch", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(Sixth.this, "Login", Toast.LENGTH_SHORT).show();
                    Intent j=new Intent(Sixth.this, Third.class);
                    startActivity(j);
                    finish();
                }
                else
                {
                    Toast.makeText(Sixth.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}