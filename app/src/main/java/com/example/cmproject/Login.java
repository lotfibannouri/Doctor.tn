package com.example.cmproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    private boolean passwordshowing = false;
    FirebaseAuth mAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText login = findViewById(R.id.username);
        final  EditText password = findViewById(R.id.password);
        final Button inscription = findViewById(R.id.signUpBtn);
        final ImageView passwordIcone = findViewById(R.id.passwordIcon);
        final Button btnAthent = findViewById(R.id.signInBtn);
        mAuth = FirebaseAuth.getInstance();
        btnAthent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = login.getText().toString() ;
                String pass = password.getText().toString() ;
                if(TextUtils.isEmpty(user) ||TextUtils.isEmpty(pass))
                    Toast.makeText(Login .this,"tous les champs sont obligatoires",Toast.LENGTH_SHORT).show();
                else
                {
                    mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(Login.this,"Utilisateur authentifié avec succés",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(Login.this ,MainActivity.class));
                       }
                       else {
                           Toast.makeText(Login.this,"Erreur d'authentification :"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                       }
                        }
                    });



                }



            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordshowing){
                    passwordshowing = false;
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcone.setImageResource(R.drawable.show);
                }else {
                    passwordshowing = true;
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcone.setImageResource(R.drawable.hide);
                }
                password.setSelection(password.length());
            }
        });


        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Inscription.class));
            }
        });
    }
}