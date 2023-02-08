package com.example.kompas.myapplication;

/**
 * Created by Kompas on 2017.03.13.
 */
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.view.LayoutInflater;

public class issokantysuzsakymaimain extends AppCompatActivity {
    private static String kodas = "";
    Button btnClosePopup,vykdyti,istrinti;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    UzsakymaiDBController controller = new UzsakymaiDBController(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.isokantysuzsakymai);
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        String value1 = intent.getStringExtra("key1");

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        expandableListDetail = veikia();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                kodas = expandableListTitle.get(groupPosition);
                initiatePopupWindow();
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });




        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }


    public PopupWindow pwindo;
    public void initiatePopupWindow() {
        try {

// We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) issokantysuzsakymaimain.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.pranesimas,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, 500, 500, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

            btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(cancel_button_click_listener);
            vykdyti = (Button) layout.findViewById(R.id.button9);
            vykdyti.setOnClickListener(vykdytiveiksmas);
            istrinti = (Button) layout.findViewById(R.id.button8);
            istrinti.setOnClickListener(istrintiveiksmas);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public OnClickListener vykdytiveiksmas = new OnClickListener() {

        public void onClick(View v) {
            String kodas123 = issokantysuzsakymaimain.getKodas();
            Toast.makeText(getApplicationContext(),
                    expandableListDetail.get(kodas123) + " List Expanded.",
                    Toast.LENGTH_SHORT).show();

        }
    };
    private OnClickListener istrintiveiksmas = new OnClickListener() {
        public void onClick(View v) {
            String kodas123 = issokantysuzsakymaimain.getKodas();
           // expandableListDetail.remove(kodas123);
            controller = new UzsakymaiDBController(getApplicationContext());
            SQLiteDatabase db = controller.getWritableDatabase();
            db.delete("uzsakymai2", "uzsakymoid=" + kodas123, null);
            Intent intent = new Intent(getBaseContext(), issokantysuzsakymaimain.class);
            startActivity(intent);

        }
    };



    private OnClickListener cancel_button_click_listener = new OnClickListener() {
        public void onClick(View v) {
            pwindo.dismiss();

        }
    };

    public static String getKodas()
    {
        return kodas;
    }




    public HashMap<String, List<String>> veikia(){

        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        PrekesDBController controller = new PrekesDBController(this);
        ArrayList<HashMap<String, String>> data2 = controller.getpavadinimas();
        int i = 0;
        final String pavadinimas[] = new String[data2.size()];
        for (HashMap<String, String> hashMap : data2) {
            for (String value : hashMap.values()) {
                pavadinimas[i] = value;
                i++;

            }
        }


        List<String> uzsakymas1 = new ArrayList<String>();
        uzsakymas1.add("1,2");
        uzsakymas1.add("1,2");
        uzsakymas1.add("1,2");
        uzsakymas1.add("1,2");



        List<String> uzsakymas2 = new ArrayList<String>();
        uzsakymas2.add("1,3");
        uzsakymas2.add("2,3");



        List<String> uzsakymas3 = new ArrayList<String>();
        uzsakymas3.add("1,3");
        uzsakymas3.add("2,3");
        uzsakymas3.add("1,1");
        uzsakymas3.add("2,1");

        String vienetai = ListViewCheckboxesActivity.getVariable();  // Accessing in Another class
        String produktai = ListViewCheckboxesActivity.getVariable1();
        String idnr = ListViewCheckboxesActivity.getVariable2();
       // List<String> pavadinimas1 = ListViewCheckboxesActivity.getkoja();
        List<String> idnumeris1 = ListViewCheckboxesActivity.getkoja1();
        List<String> kiekis1 = ListViewCheckboxesActivity.getkoja2();
        int uzsakymas = ListViewCheckboxesActivity.getint();
        String uzsakymoid = String.valueOf(uzsakymas);
        //expandableListDetail.put("1", uzsakymas1);
        // expandableListDetail.put("2", uzsakymas2);
        // expandableListDetail.put("3", uzsakymas3);

       HashMap<String, List<String>> superlistas = new HashMap<String, List<String>>();

        int UzsakymoID = ListViewCheckboxesActivity.getint();

        String UzskymoID1 = Integer.toString(UzsakymoID);

        UzsakymaiDBController controller3 = new UzsakymaiDBController(this);
        ArrayList<HashMap<String, String>> data5 = controller3.getuzsakymoid();


        ArrayList<HashMap<String, String>> data16 = controller3.getuzsakymas();

        int l = 0;
        final String uzsakymas111[] = new String[data16.size()];

        for (HashMap<String, String> hashMap : data16) {


            for (String value1 : hashMap.values()) {


                uzsakymas111[l] = value1 ;
                List<String> stringList = new ArrayList<String>(Arrays.asList(uzsakymas111[l]));

                String vupvup = Integer.toString(l+1);
                expandableListDetail.put(vupvup,stringList);


                l++;

            }

        }






        ArrayList<HashMap<String, String>> data3 = controller.getid();
        int b = 0;
        final String id[] = new String[data3.size()];
        for (HashMap<String, String> hashMap : data3) {
            for (String value1 : hashMap.values()) {
              //  String uzsakymonumeris = Integer.toString(l+1);
                id[b] = value1 ;

                b++;

            }
        }






       // expandableListDetail = ListViewCheckboxesActivity.getsuperlistas();




        return expandableListDetail;
    }

}