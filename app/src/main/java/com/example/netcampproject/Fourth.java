package com.example.netcampproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.shobhitpuri.custombuttons.GoogleSignInButton;

import org.jetbrains.annotations.NotNull;

public class Fourth extends AppCompatActivity {
    Button b1;
    GoogleSignInButton signInButton;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fourth);
        b1=(Button)findViewById(R.id.button11);
        signInButton=(GoogleSignInButton) findViewById(R.id.signin);
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("649125965475-n0jldb8avq399s41ier04e8nrftd15lk.apps.googleusercontent.com").requestEmail().build();
        googleSignInClient= GoogleSignIn.getClient(Fourth.this, googleSignInOptions);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fourth.this, Second.class);
                startActivity(i);
                finish();
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=googleSignInClient.getSignInIntent();
                startActivityForResult(j, 10);
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            Intent k=new Intent(Fourth.this, Third.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(k);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10)
        {
            Task<GoogleSignInAccount>signInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
            if (signInAccountTask.isSuccessful())
            {
                Toast.makeText(this, "Sign In", Toast.LENGTH_SHORT).show();
                try {
                    GoogleSignInAccount googleSignInAccount=signInAccountTask.getResult(ApiException.class);
                    if (googleSignInAccount!=null)
                    {
                        AuthCredential authCredential= GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(Fourth.this, "Database Updated", Toast.LENGTH_SHORT).show();
                                    Intent l=new Intent(Fourth.this, Third.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(l);
                                }
                                else
                                {
                                    Toast.makeText(Fourth.this, "Updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
                catch (ApiException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}