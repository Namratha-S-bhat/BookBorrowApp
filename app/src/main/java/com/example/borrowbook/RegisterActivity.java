package com.example.borrowbook;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.borrowbook.databinding.ActivityRegisterBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    //view binding
    private ActivityRegisterBinding binding;

    //firebase auth
    private FirebaseAuth firebaseAuth;

    //progress dialog


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance();
        //setup progress dialog

        //handle click, go back
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //handle click,begin register
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private String name = "",email="",password="";
    private void validateData() {
        /*Before creating account, lets do some data validations*/

        //get data
        name = binding.nameEt.getText().toString().trim();
        email = binding.emailEt.getText().toString().trim();
        password = binding.passwordEt.getText().toString().trim();
        String cPassword = binding.cPasswordEt.getText().toString().trim();

        //validate data
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"Enter your name...",Toast.LENGTH_SHORT).show();
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           Toast.makeText(this,"Invalid email pattern",Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"Enter password...!",Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(cPassword)) {
           Toast.makeText(this,"Confirm Password...!",Toast.LENGTH_SHORT).show();
        }

        else if (!password.equals(cPassword)) {
            Toast.makeText(this,"Password doesn't match...!",Toast.LENGTH_SHORT).show();
        }

        else {
            createUserAccount();
        }
    }

    private void createUserAccount() {

    }
}