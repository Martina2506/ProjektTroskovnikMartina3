package com.example.trokovnikmartina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends TroskovnikActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.unos_troskova_button).setOnClickListener(this);
        findViewById(R.id.izvoz_troskova_button).setOnClickListener(this);
        findViewById(R.id.pregled_troskova_button).setOnClickListener(this);

        Toast.makeText(this, String.format("Uspješno ste se prijavili!"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.unos_troskova_button:
                startActivity(new Intent(this, UnosTroskova.class));
                break;
            case R.id.izvoz_troskova_button:
                startActivity(new Intent(this, IzvozTroskova.class));
                break;
            case R.id.pregled_troskova_button:
                startActivity(new Intent(this, PregledTroskova.class));
                break;

        }
    }
}
