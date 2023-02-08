package com.example.kompas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kompas on 2017.01.16.
 */

public class pradzia extends Activity {
    private static HashMap<String, List<String>> geraslistas = new HashMap<String, List<String>>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pradzia);

        ImageButton next = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton apie = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton istorija = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton prekes = (ImageButton) findViewById(R.id.image_button4);
         //Button meginam = (Button) findViewById(R.id.button1);
        Button meginam1 = (Button) findViewById(R.id.button);
        Button prekiuRedagavimas = (Button) findViewById(R.id.button7);
        Button uzsakymuDB = (Button) findViewById(R.id.button10);
        Button meginam6 = (Button) findViewById(R.id.button6);
     Button login = (Button) findViewById(R.id.button12);
        Button naujaPreke = (Button) findViewById(R.id.button5);


        uzsakymuDB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, UzsakymaiList.class);
                startActivity(i);



            }




        });


        naujaPreke.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, naujapreke.class);

                //Change the activity.
                // i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                startActivity(i);




            }




        });



        prekiuRedagavimas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, PrekiuRedagavimas.class);

                //Change the activity.
                // i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                startActivity(i);




            }




        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, ListViewCheckboxesActivity.class);

                //Change the activity.
                // i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                startActivity(i);




            }




        });
        meginam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, ListViewCheckboxesActivity.class);
                startActivity(i);




            }




        });
        meginam6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, issokantysuzsakymaimain.class);
                startActivity(i);




            }




        });
   login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, pradzialogin.class);
                startActivity(i);




            }




        });






        prekes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, prekes.class);
                startActivity(i);




            }




        });

        apie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, apie.class);

                //Change the activity.
                // i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                startActivity(i);




            }




        });
        istorija.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(pradzia.this, issokantysuzsakymaimain.class);

                //Change the activity.
                // i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                startActivity(i);




            }




        });

    }
    public static HashMap<String, List<String>> getgeraslistas(){
        return geraslistas;
    }
}