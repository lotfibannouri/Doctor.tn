package com.example.cmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        final EditText email = findViewById(R.id.username);
        final EditText mobile = findViewById(R.id.tel);
        final EditText password = findViewById(R.id.password);
        final EditText adresse = findViewById(R.id.adresse);
        final AppCompatButton inscription = findViewById(R.id.signUpBtn);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getMobileTxt = mobile.getText().toString();
                final String getEmailTxt = email.getText().toString();
                // opening otp verification activity with mobile and mail
                Intent intent = new Intent( Inscription.this,CodeVerification.class);
                intent.putExtra("mobile",getMobileTxt);
                intent.putExtra("email", getEmailTxt);
                startActivity(intent);

            }
        });

    }
}