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

import com.example.cmproject.Models.Registration;
import com.example.cmproject.Services.ApiInterface;
import com.example.cmproject.Services.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Inscription extends AppCompatActivity {
    //FirebaseAuth mAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        //mAuth = FirebaseAuth.getInstance();
        final EditText nom = findViewById(R.id.username);
        final EditText prenom = findViewById(R.id.prenom);
        final EditText password = findViewById(R.id.password);
        final EditText login = findViewById(R.id.login);
        final EditText adresse = findViewById(R.id.adresse);
        final AppCompatButton btnInscription = findViewById(R.id.signInBtn);

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String NomTxt = nom.getText().toString();
                final String PrenomTxt = prenom.getText().toString();
                final String AdresseTxt = adresse.getText().toString();
                final String LoginTxt = login.getText().toString();
                final String PasswordTxt = password.getText().toString();
                // opening otp verification activity with mobile and mail
               /*Intent intent = new Intent( Inscription.this,CodeVerification.class);
                intent.putExtra("mobile",getMobileTxt);
                intent.putExtra("email", getEmailTxt);
                startActivity(intent);*/
                if (TextUtils.isEmpty(LoginTxt)){
                    login.setError("Email ne peut pas être vide");
                    login.requestFocus();
                }
                else if(TextUtils.isEmpty(PasswordTxt)){
                    password.setError("password ne peut pas être vide");
                    password.requestFocus();
                }
                else {
                   /* mAuth.createUserWithEmailAndPassword(loginTxt,passwordTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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
                    });*/

                   Registration registration = new Registration(NomTxt,PrenomTxt,LoginTxt,AdresseTxt,PasswordTxt);
                    ApiInterface apiInterface = RetrofitClient.getInstanceRetrofit().create(ApiInterface.class) ;
                    Call<ResponseBody> call = apiInterface.Registrated(registration) ;

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Toast.makeText(Inscription.this,"création d'utilisateur avec succés"+ response.message(),Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Inscription.this, Login.class));
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(Inscription.this,"Erreur d'enregistrement :"+t.getMessage(),Toast.LENGTH_SHORT).show();
                            System.out.println(t.getMessage());

                        }
                    });
                }
            }
        });

    }
}