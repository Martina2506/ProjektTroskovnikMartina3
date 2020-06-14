package com.example.trokovnikmartina;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PregledTroskova extends TroskovnikActivity implements SearchView.OnQueryTextListener {

    ArrayList<TrosakModel> troskovi;
    ListView list;
    Activity me;
    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregled_troskova);
        troskovi=TrosakModel.getAll(this);
        me=this;
        sv=(SearchView) findViewById(R.id.pregled_troskova_search);
        list=(ListView)findViewById(R.id.pregled_troskova_list);
        list.setAdapter(new MyListAdapter(this));
        list.setTextFilterEnabled(true);
        setupSearchView();
    }
    private void setupSearchView() {
        sv.setIconifiedByDefault(false);
        sv.setOnQueryTextListener(this);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("Search Here");
    }
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            list.clearTextFilter();
        } else {
            list.setFilterText(newText.toString());
            list.deferNotifyDataSetChanged();
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    public class MyListAdapter extends ArrayAdapter<TrosakModel> {
        public MyListAdapter(Context context) {
            super(context, 0, troskovi);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) convertView= LayoutInflater.from(getContext()).inflate(R.layout.trosak_view, null, false);
            TrosakModel data=troskovi.get(position);
            String firstPart="Naziv: "+data.naziv_troska+" \n"+"Vrsta: "+data.vrsta_troska+" \n"
                    +"Iznos: "+String.valueOf(data.iznos)+"\n"+"Datum: "+data.datum;
            ((TextView)convertView.findViewById(R.id.osnovno)).setText(firstPart);
            return convertView;
        }
    }
}


