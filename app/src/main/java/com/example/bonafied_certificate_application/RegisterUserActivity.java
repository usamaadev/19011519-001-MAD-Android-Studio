package com.example.bonafied_certificate_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.Normalizer;

public class RegisterUserActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    LoginAuthDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);

        username = findViewById(R.id.edittxtuserreg);
        password = findViewById(R.id.edittxtpassreg);
        repassword = findViewById(R.id.edittxtpassregrepeat);




        DB = new LoginAuthDB(this);



        findViewById(R.id.btnRegAuthreg).setOnClickListener(v ->{
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(RegisterUserActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            else {
                if (pass.equals(repass)){
                    Boolean checkUser = DB.checkUsername(user);
                    if (checkUser==false){
                        Boolean insert = DB.insertData(user, pass);
                        if (insert == true){
                            Toast.makeText(RegisterUserActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(RegisterUserActivity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterUserActivity.this, "User already exists! Please login.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegisterUserActivity.this, "Password not matching!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}