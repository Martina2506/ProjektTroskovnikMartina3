package com.example.trokovnikmartina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends TroskovnikActivity implements View.OnClickListener{
    EditText username, password, loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        findViewById(R.id.loginbutton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginbutton:
                if (username.getText().toString().equals("martina") && password.getText().toString().equals("sekulo")) {
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                } else {
                    showError("Korisničko ime i lozinka nisu točni.");
                }
                break;
        }
    }
}

