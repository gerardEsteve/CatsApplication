package com.e.catsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    TextInputEditText editTextUsername;
    TextInputEditText editTextPassword;
    TextInputLayout layoutUsername;
    TextInputLayout layoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.button);
        editTextPassword = findViewById(R.id.edtTextPass);
        editTextUsername = findViewById(R.id.edtTextUser);
        layoutPassword = findViewById(R.id.textFieldPassword);
        layoutUsername = findViewById(R.id.textFieldUsername);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextPassword.getText().toString().isEmpty() && editTextUsername.getText().toString().isEmpty()){
                    layoutPassword.setError(getResources().getString(R.string.missing_password));
                    layoutUsername.setError(getResources().getString(R.string.missing_username));
                }
                else if (editTextPassword.getText().toString().isEmpty()){
                    layoutPassword.setError(getResources().getString(R.string.missing_password));
                }
                else if (editTextUsername.getText().toString().isEmpty()){
                    layoutUsername.setError(getResources().getString(R.string.missing_username));
                }
                else {
                    layoutUsername.setErrorEnabled(false);
                    layoutPassword.setErrorEnabled(false);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    editTextPassword.getText().clear();
                    editTextUsername.getText().clear();
                    editTextPassword.clearFocus();
                    editTextUsername.clearFocus();
                }
            }
        });
    }

}
