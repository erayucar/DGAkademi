package com.eray.projectposapp.app.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.eray.projectposapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    private EditText editEmail;
    private EditText editPassword;
    private EditText editName;
    private String txtEmail, txtPassword, txtName;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private HashMap<String, Object> mData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editEmail = (EditText)findViewById(R.id.sign_up_editMail);
        editPassword = (EditText)findViewById(R.id.sign_up_editPassword);
        editName = (EditText)findViewById(R.id.sign_up_editName);




        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void signUp(View v){

        txtEmail = editEmail.getText().toString();
        txtPassword = editPassword.getText().toString();
        txtName = editName.getText().toString();

        if (!TextUtils.isEmpty(txtName) && !TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)){
            mAuth.createUserWithEmailAndPassword(txtEmail, txtPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                mUser = mAuth.getCurrentUser();

                                mData = new HashMap<>();
                                mData.put("Kullanıcı Adı", txtName);
                                mData.put("Kullanıcı Email", txtEmail);
                                mData.put("Kullanıcı Password", txtPassword);
                                mData.put("KullanıcıId", mUser.getUid());

                                mReference.child("Kullanıcılar").child(mUser.getUid())
                                        .setValue(mData)
                                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(SignUpActivity.this, "Kayıt İşlemi başırılı. Ana Sayfaya Yönlendiriliyorsunuz..", Toast.LENGTH_SHORT).show();
                                                    Intent BacktotheMain = new Intent(SignUpActivity.this, LogInActivity.class);
                                                    startActivity(BacktotheMain);
                                                }else
                                                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });


                            }else
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
        }else
            Toast.makeText(this, "İsim, Email Ve Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();






    }
}