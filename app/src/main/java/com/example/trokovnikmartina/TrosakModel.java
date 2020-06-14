package com.example.trokovnikmartina;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TrosakModel {

    public static String storageID="STORAGE_TROSAK";
    public int id;
    public double iznos;
    public String datum, naziv_troska, vrsta_troska;


    public static ArrayList<TrosakModel> getAll(Activity a){
        SharedPreferences sp=a.getSharedPreferences(storageID, Context.MODE_PRIVATE);
        Set keys=sp.getAll().keySet();
        ArrayList<TrosakModel> list = new ArrayList<>();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            list.add(new TrosakModel(Integer.valueOf(it.next()), a));
        }
        return list;
    }
    public TrosakModel(){}

    public void save(Activity c) {
        SharedPreferences sp=c.getSharedPreferences(storageID, Context.MODE_PRIVATE);
        id=sp.getAll().keySet().size()+1;
        JSONObject o=new JSONObject();

        try {
            o.put("naziv_troska", naziv_troska);
            o.put("vrsta_troska", vrsta_troska);
            o.put("iznos", iznos);
            o.put("datum", datum);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        sp.edit().putString(String.format("%d", id), o.toString()).commit();
        while(o.length()>0)
            o.remove(o.keys().next());

    }
    public TrosakModel(int id, Activity a) {
        SharedPreferences sp=a.getSharedPreferences(storageID, Context.MODE_PRIVATE);
        this.id=id;
        try {
            JSONObject o = new JSONObject(sp.getString(String.format("%d", id), ""));
            this.naziv_troska = o.getString("naziv_troska");
            this.vrsta_troska =o.getString("vrsta_troska");
            this.datum=o.getString("datum");
            this.iznos=o.getDouble("iznos");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
