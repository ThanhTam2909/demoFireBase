package com.example.demofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {

    private EditText edt_Email, edt_Password;
    private Button btn_Login, btn_Singup;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        edt_Email = (EditText) findViewById(R.id.edt_email);
        edt_Password = (EditText) findViewById(R.id.edt_pass);
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Singup = (Button) findViewById(R.id.btn_singup);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_Email.getText().toString().trim();
                String password = edt_Password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8){
                    Toast.makeText(MainActivity.this, "Password phải trên 8 ký tự", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

}