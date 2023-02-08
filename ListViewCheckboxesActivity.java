package com.example.kompas.myapplication;



        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.HashMap;
        import java.util.List;



        import android.app.Activity;
        import android.content.ContentValues;
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.View.OnClickListener;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.RelativeLayout;
        import android.widget.ScrollView;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.AdapterView.OnItemClickListener;

        import static android.R.id.list;
        import static com.example.kompas.myapplication.R.id.spinner1;


public class ListViewCheckboxesActivity extends Activity  {
    PrekesDBController controller1 = new PrekesDBController(this);
    public String valuey;
    MyCustomAdapter dataAdapter = null;
    PrekesDBController controller = new PrekesDBController(this);
    UzsakymaiDBController controller2 = new UzsakymaiDBController(this);
    private static String lapce = "";
    private static String kojine = "";
    private static String idnr = "";
    private static int uzsakymonr = 0;
    private static String listString = "";
  //  private static List<String> pavadinimas = new ArrayList<String>();
   // private static List<String> pavadinimas1 = new ArrayList<String>();
    private static List<String> idnumeris= new ArrayList<String>();
    private static List<String> kiekis = new ArrayList<String>();
    private static ArrayList<String> idnumeris1 = new ArrayList<String>();
    private static HashMap<String, List<String>> superlistas = new HashMap<String, List<String>>();
    public Context mContext;
    ScrollView sv;
    TextView infotext;
    CheckBox check;
    LinearLayout ll;
    Spinner spinner2, ss;
    public Spinner jopapa;
    Button clickButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
       // mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main123);

       mContext = this;
     //   SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
      // if(!prefs.getBoolean("firstTime", false)) {
         //   HashMap<String, List<String>> geraslistas=pradzia.getgeraslistas();
         //   superlistas.putAll(geraslistas);
         //   SharedPreferences.Editor editor = prefs.edit();
        //    editor.putBoolean("firstTime", true);
        //    editor.commit();
  //      }


        ss = (Spinner) findViewById(R.id.spinner11);
        //Generate list View from ArrayList
        displayListView();

        String valuey = veikia();
        checkButtonClick(valuey);

        getVariable();
        getVariable1();
        getVariable2();
       // getkoja();
        getkoja1();
        getkoja2();
        getkoja3();
        getint();
        getuzsakymonr();
        getsuperlistas();
    }

    private void displayListView() {

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




        ArrayList<HashMap<String, String>> data3 = controller.getid();
        int l = 0;
        final String id[] = new String[data3.size()];
        for (HashMap<String, String> hashMap : data3) {
            for (String value1 : hashMap.values()) {
                id[l] = value1 ;
                l++;

            }
        }

        List<String> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1, id);





        //Array list of countries
     ArrayList<Country> countryList = new ArrayList<Country>();
        for(int k=0; k<data2.size(); k++) {

           Country country = new Country(pavadinimas[k],id[k],false);
            countryList.add(country);
        }

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.country_info, countryList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Country country = (Country) parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(),
                        //"Clicked on Row: " + country.getName(),
                        //Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Country> {

        private ArrayList<Country> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Country> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<Country>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            CheckBox name;
            TextView code;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        String lopas = String.valueOf(jopapa.getSelectedItem());
                        Country country = (Country) cb.getTag();
                       // Toast.makeText(getApplicationContext(),
                           //     "Clicked on Checkbox: " + cb.getText() +
                              //          " is " + cb.isChecked(),
                              //  Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                        //country.setKiekis(lopas);
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = countryList.get(position);
            holder.code.setText(" (" +  country.getCode() + ")");
            holder.name.setText(country.getName());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);

            return convertView;

        }

    }
  public String veikia() {
      ArrayList<HashMap<String, String>> data2 = controller.getpavadinimas();
      String valuey = "";

      for (int kl = 0; kl < data2.size(); kl++) {
          //spinner2 = (Spinner) findViewById(R.id.spinner11);

          ScrollView sv = (ScrollView) findViewById(R.id.myscroll123);
          LinearLayout ll = (LinearLayout) findViewById(R.id.mylinearLayout123);

          LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View view = inflater.inflate(R.layout.naujasuzsakymailist123, null);


          ll.addView(view);

          //sikna = int kl;

              jopapa = (Spinner) findViewById(R.id.spinner11);
              jopapa.setId(kl);

              List<String> list = new ArrayList<String>();
                list.add("0");
              list.add("1");
              list.add("2");
              list.add("3");
              list.add("4");
              list.add("5");
              list.add("6");
              list.add("7");
              list.add("8");
              list.add("9");

              ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                      android.R.layout.simple_spinner_item, list);
              dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
              jopapa.setAdapter(dataAdapter);

      }








     return valuey;
  }


    public static String getVariable()
    {
        return lapce;
    }

    public static String getVariable1()
    {
        return kojine;
    }

    public static String getVariable2()
    {
        return idnr;
    }


    public static List<String> getkoja1()
    {
        return idnumeris;
    }
    public static String getkoja3()
    {
        return listString;
    }

    public static List<String> getkoja2()
    {
        return kiekis;
    }

    public static int getint()
    {
        return uzsakymonr;
    }

    public static HashMap<String, List<String>> getsuperlistas(){
        return superlistas;
    }
    public static ArrayList<String> getuzsakymonr(){
        return idnumeris1;
    }
    public void checkButtonClick(final String valuey) {

        //jopapa = (Spinner) findViewById(R.id.spinner1);
      //  spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {
            ArrayList<HashMap<String, String>> data2 = controller.getpavadinimas();
            @Override
            public void onClick(View v) {
                System.out.println("koja");
                uzsakymonr++;
                String gerai = Integer.toString(uzsakymonr);

                //int gerai123 = uzsakymonr;
               List<String> pavadinimas = new ArrayList<String>();
               // List<String> idnumeris = new ArrayList<String>();
               // List<String> kiekis = new ArrayList<String>();
               // Log.d("TAG", valuey);
               /* for(int k=0; k<data2.size();k++){
                    Spinner sp=(Spinner)findViewById(k);
                    String bybis ="";
                    bybis = String.valueOf(sp.getSelectedItem());
                    Toast.makeText(getApplicationContext(),
                            "Clicked on Row: " + bybis,
                            Toast.LENGTH_LONG).show();
                    System.out.println(bybis);
                }
                */
                String valuey11 = "";

                valuey11 = String.valueOf(jopapa.getSelectedItem());

               //String gg = String.valueOf(ss.getSelectedItem());

                //String snarglys = String.valueOf(jopapa.getSelectedItem());
              //System.out.println(valuey11);
                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Country> countryList = dataAdapter.countryList;

                for(int i=0;i<countryList.size();i++){

                    Country country = countryList.get(i);

                    if(country.isSelected()){
                        String lopas = country.getCode();
                        int foo = Integer.parseInt(lopas);
                        int loo = foo-1;
                        Spinner sp=(Spinner)findViewById(loo);
                        String bybis ="";


                        bybis = String.valueOf(sp.getSelectedItem());
                        responseText.append("\n" + country.getName()+" " + bybis);



                        String turgus = " "+country.getCode()+","+bybis;
                        String turgus1 = country.getCode();
                        kojine = turgus;
                        lapce = bybis;
                        idnr = turgus1;
                        pavadinimas.add(turgus);




                        idnumeris.add(turgus1);
                        kiekis.add(lapce);

                    }
                }


                superlistas.put(gerai,pavadinimas);
                listString = TextUtils.join(",",pavadinimas);

               String uzsakymas = android.text.TextUtils.join(",", pavadinimas);

                //String prekesID = superlistas.keySet().toString();
               // String reikiamasKiekis = superlistas.values().toString();
                controller2 = new UzsakymaiDBController(getApplicationContext());
                SQLiteDatabase db = controller2.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("klientoid", "");
                cv.put("prekes", uzsakymas);
                cv.put("suma", "");
                db.insert("uzsakymai2", null, cv);
                db.close();
               // System.out.println(gerai+""+pavadinimas);
                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });
        Button myButton12 = (Button) findViewById(R.id.vykdyti);
        myButton12.setOnClickListener(new OnClickListener() {
            ArrayList<HashMap<String, String>> data2 = controller.getpavadinimas();
            @Override
            public void onClick(View v) {
                System.out.println("koja");
                uzsakymonr++;
                String gerai = Integer.toString(uzsakymonr);

                //int gerai123 = uzsakymonr;
                List<String> pavadinimas = new ArrayList<String>();
                // List<String> idnumeris = new ArrayList<String>();
                // List<String> kiekis = new ArrayList<String>();
                // Log.d("TAG", valuey);
               /* for(int k=0; k<data2.size();k++){
                    Spinner sp=(Spinner)findViewById(k);
                    String bybis ="";
                    bybis = String.valueOf(sp.getSelectedItem());
                    Toast.makeText(getApplicationContext(),
                            "Clicked on Row: " + bybis,
                            Toast.LENGTH_LONG).show();
                    System.out.println(bybis);
                }
                */
                String valuey11 = "";

                valuey11 = String.valueOf(jopapa.getSelectedItem());

                //String gg = String.valueOf(ss.getSelectedItem());

                //String snarglys = String.valueOf(jopapa.getSelectedItem());
                //System.out.println(valuey11);
                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Country> countryList = dataAdapter.countryList;

                for(int i=0;i<countryList.size();i++){

                    Country country = countryList.get(i);

                    if(country.isSelected()){
                        String lopas = country.getCode();
                        int foo = Integer.parseInt(lopas);
                        int loo = foo-1;
                        Spinner sp=(Spinner)findViewById(loo);
                        String bybis ="";


                        bybis = String.valueOf(sp.getSelectedItem());
                        responseText.append("\n" + country.getName()+" " + bybis);



                        String turgus = " "+country.getCode()+","+bybis;
                        String turgus1 = country.getCode();
                        kojine = turgus;
                        lapce = bybis;
                        idnr = turgus1;
                        pavadinimas.add(turgus);




                        idnumeris.add(turgus1);
                        kiekis.add(lapce);

                    }
                }


                superlistas.put(gerai,pavadinimas);
                listString = TextUtils.join(",",pavadinimas);

                String uzsakymas = android.text.TextUtils.join(",", pavadinimas);

                //String prekesID = superlistas.keySet().toString();
                // String reikiamasKiekis = superlistas.values().toString();

                // System.out.println(gerai+""+pavadinimas);
                Toast.makeText(getApplicationContext(),
                        gerai+""+pavadinimas, Toast.LENGTH_LONG).show();

            }
        });

    }

}