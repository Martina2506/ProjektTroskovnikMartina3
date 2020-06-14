package com.example.trokovnikmartina;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TroskovnikActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
    }

    public void showError(String msg) {
        new AlertDialog.Builder(this).setTitle("Greška").setNeutralButton("Ok", null).setMessage(msg).create().show();
    }
}
