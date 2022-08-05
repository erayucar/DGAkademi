package com.DGakademi.simpleloginapp.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.DGakademi.simpleloginapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;
    private String txtEmail, txtPassword;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Button SignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        editEmail = (EditText)findViewById(R.id.Log_in_editMail);
        editPassword = (EditText)findViewById(R.id.Log_in_editPassword);
        SignUp = findViewById(R.id.SignUpButton);


        mAuth = FirebaseAuth.getInstance();

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }

    public void LogIn(View view ){
         txtEmail = editEmail.getText().toString();
        txtPassword = editPassword.getText().toString();

        if (!TextUtils.isEmpty(txtEmail)&& !TextUtils.isEmpty(txtPassword)){
        mAuth.signInWithEmailAndPassword(txtEmail,txtPassword)
                .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        mUser = mAuth.getCurrentUser();
                        System.out.println("Kullanıcı adı" + mUser.getDisplayName());
                        System.out.println("Kullanıcı email" + mUser.getEmail());
                        System.out.println("Kullanıcı uid" + mUser.getUid());
                        Intent GetInside = new Intent(LogInActivity.this, WelcomePageActivity.class);
                        startActivity(GetInside);

                    }
                }).addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LogInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        }else
            Toast.makeText(this, "Email Ve Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();

    }


}