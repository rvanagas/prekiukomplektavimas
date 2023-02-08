package com.example.kompas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kompas on 2017.01.16.
 */

public class spinner extends Activity {
    private Spinner spinner1, spinner2;
    PrekesDBController controller = new PrekesDBController(this);
    ListView ls;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.naujasuzsakymailist12);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ls = (ListView) findViewById(R.id.prekeslist);
        addItemsOnSpinner1();
        addItemsOnSpinner2();

            }

    public void addItemsOnSpinner2() {
        // setContentView(R.layout.naujasuzsakymailist);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        // ArrayList<HashMap<String, String>> data2 = controller.getpavadinimas();
        ArrayList<HashMap<String, String>> data2 = controller.getpavadinimas();
        int i = 0;
        final String pavadinimas[] = new String[data2.size()];
        for (HashMap<String, String> hashMap : data2) {
            for (String value : hashMap.values()) {
                pavadinimas[i] = value ;
                i++;

            }
        }

        List<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, pavadinimas);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);


    }



}






