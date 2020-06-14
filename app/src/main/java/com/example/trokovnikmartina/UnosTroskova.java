package com.example.trokovnikmartina;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class UnosTroskova extends TroskovnikActivity implements View.OnClickListener {

    EditText nazivTroska, iznosTroska, vrstaTroska, eText;
    DatePickerDialog picker;
    Button datum_button;
    TextView tvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unos_troskova);

        nazivTroska=(EditText)findViewById(R.id.naziv_troska);
        iznosTroska =(EditText)findViewById(R.id.iznos);
        vrstaTroska=(EditText) findViewById(R.id.vrsta_troska);
        findViewById(R.id.spremi).setOnClickListener(this);

        tvw=(TextView)findViewById(R.id.textView1);
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(UnosTroskova.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        datum_button=(Button)findViewById(R.id.datum_button);
        datum_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ eText.getText());
            }
        });
    }
    public void onClick(View v) {
        if(nazivTroska.getText().toString().isEmpty() || vrstaTroska.getText().toString().isEmpty()
                ||iznosTroska.getText().toString().isEmpty())
            showError("Niste ispunili sva polja!");
        else {
            TrosakModel data=new TrosakModel();
         //   data.datum=datum.getText().toString();
            data.iznos=Double.valueOf(iznosTroska.getText().toString());
            data.naziv_troska = nazivTroska.getText().toString();
            data.vrsta_troska = vrstaTroska.getText().toString();
            data.datum = eText.getText().toString();
            data.save(this);
            finish();
            Toast.makeText(this, String.format("Spremljeno!"), Toast.LENGTH_SHORT).show();

        }
    }
}
