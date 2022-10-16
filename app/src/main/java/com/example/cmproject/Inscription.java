package com.example.cmproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inscription extends AppCompatActivity {
    FirebaseAuth mAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        mAuth = FirebaseAuth.getInstance();
        final EditText email = findViewById(R.id.username);
        final EditText mobile = findViewById(R.id.tel);
        final EditText password = findViewById(R.id.password);
        final EditText login = findViewById(R.id.login);
        final EditText adresse = findViewById(R.id.adresse);
        final AppCompatButton btnInscription = findViewById(R.id.signInBtn);

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String MobileTxt = mobile.getText().toString();
                final String EmailTxt = email.getText().toString();
                final String adresseTxt = adresse.getText().toString();
                final String loginTxt = login.getText().toString();
                final String passwordTxt = password.getText().toString();
                // opening otp verification activity with mobile and mail
               /*Intent intent = new Intent( Inscription.this,CodeVerification.class);
                intent.putExtra("mobile",getMobileTxt);
                intent.putExtra("email", getEmailTxt);
                startActivity(intent);*/
                if (TextUtils.isEmpty(loginTxt)){
                    login.setError("Email ne peut pas être vide");
                    login.requestFocus();
                }
                else if(TextUtils.isEmpty(passwordTxt)){
                    password.setError("password ne peut pas être vide");
                    password.requestFocus();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(loginTxt,passwordTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Inscription.this,"création d'utilisateur avec succés",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Inscription.this, Login.class));
                            }
                            else{
                                Toast.makeText(Inscription.this,"Erreur d'enregistrement :"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });

    }
}