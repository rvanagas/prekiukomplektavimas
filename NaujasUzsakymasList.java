package com.example.kompas.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static android.R.interpolator.linear;
import static com.example.kompas.myapplication.R.id.txtprekesid;


public class NaujasUzsakymasList extends ActionBarActivity {
    PrekesDBController controller = new PrekesDBController(this);
    ListView ls;
    ScrollView sv;
    TextView infotext;
    CheckBox check;
    LinearLayout ll;
    EditText vnt;
    private Spinner spinner1, spinner2, spinner11, spinner22;
    private Button btnSubmit, btnprideti;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naujasuzsakymailist);
        ScrollView sv = (ScrollView) findViewById(R.id.myscroll);
        LinearLayout ll = (LinearLayout) findViewById(R.id.mylinearLayout);
        mContext = this;
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // delete = (Button) findViewById(R.id.btndel);
        ls = (ListView) findViewById(R.id.prekeslist);
        infotext = (TextView) findViewById(R.id.txtresulttext);
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
     //   spinner11 = (Spinner) findViewById(R.id.spinner11);
      //  spinner22 = (Spinner) findViewById(R.id.spinner22);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnprideti = (Button) findViewById(R.id.prideti);
        // check = (CheckBox) findViewById(R.id.checkBox4);
        // vnt = (EditText) findViewById(R.id.editText2);
        addItemsOnSpinner2();
        addItemsOnSpinner1();
        addListenerOnButton();
        addListenerOnButtonprideti();
        addListenerOnSpinnerItemSelection();


    }

    /// delete.setOnClickListener(new View.OnClickListener() {
    // @Override
    //public void onClick(View v) {
    //  controller = new UzsakymaiDBController(getApplicationContext());
    /// SQLiteDatabase db = controller.getWritableDatabase();
    // db.delete("uzsakymai", "uzsakymoid=" + txtuzsakymoid, null);
    // }

    //  });
    //   @Override
    //  public boolean onCreateOptionsMenu(Menu menu) {
    //    getMenuInflater().inflate(R.menu.menu_main, menu);
    //   return true;
    // }
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




    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner11 = (Spinner) findViewById(R.id.spinner11);
        spinner22 = (Spinner) findViewById(R.id.spinner22);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);






        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              Toast.makeText(NaujasUzsakymasList.this,
                        "Pasirinkot : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()) ,
                        Toast.LENGTH_SHORT).show();



            }

        });

    }

    public void addListenerOnButtonprideti() {


      //  spinner11 = (Spinner) findViewById(R.id.spinner11);
        //spinner22 = (Spinner) findViewById(R.id.spinner22);




        btnprideti = (Button) findViewById(R.id.prideti);




            btnprideti.setOnClickListener(new View.OnClickListener() {

                int j = 3;
                @Override

                public void onClick(View v) {


                    ScrollView sv = (ScrollView) findViewById(R.id.myscroll);
                    LinearLayout ll = (LinearLayout) findViewById(R.id.mylinearLayout);

                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


                    View view = inflater.inflate(R.layout.naujasuzsakymailist12, null);
                  // Button btnprideti = (Button) view.findViewById(R.id.spinner1);





                 // btnprideti.setText("Nr." + j);
                    //cb.isChecked();
                    ll.addView(view);

                   int count=j;



                    int count1=j+20;
                    Spinner jopapa1 = new Spinner(mContext);
                    jopapa1 = (Spinner) findViewById(R.id.spinner22);
                    jopapa1.setId(count1);


                    Spinner jopapa = new Spinner(mContext);
                    jopapa = (Spinner) findViewById(R.id.spinner11);
                    jopapa.setId(count);


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
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, list);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    jopapa.setAdapter(dataAdapter);







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


                    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, arrayList);
                    dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    jopapa1.setAdapter(dataAdapter1);

                    Toast.makeText(NaujasUzsakymasList.this,

                                    "\nSpinner 1id : "+  count +
                                    "\nSpinner 2id : "+ count1 ,
                            Toast.LENGTH_SHORT).show();

                    //jopapa = (Spinner) findViewById(R.id.spinner1);
                    jopapa.setOnItemSelectedListener(new CustomOnItemSelectedListener());
                  //  spinner2 = (Spinner) findViewById(R.id.spinner2);
                    jopapa1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

                    j++;

                }

            });

        }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void DisplayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}