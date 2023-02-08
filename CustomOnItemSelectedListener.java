package com.example.kompas.myapplication;

/**
 * Created by Kompas on 2017.02.19.
 */

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
    int j=0;
    ArrayList<String> mylist = new ArrayList<String>();
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();



            String txt = parent.getSelectedItem().toString();
            mylist.add(txt);
            System.out.println(mylist);


        j++;
        }


    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}