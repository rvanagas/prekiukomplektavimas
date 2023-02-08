package com.example.kompas.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.kompas.myapplication.R.id.txtuzsakymoid;


public class UzsakymaiList extends ActionBarActivity {
    UzsakymaiDBController controller = new UzsakymaiDBController(this);
    ListView ls;
    TextView infotext;
    CheckBox pazymetas;
    Button delete, btnviewAll, btn1;
    //String[] uzsakymoid={};//animal names array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uzsakymailist);
        // delete = (Button) findViewById(R.id.btndel);
        ls = (ListView) findViewById(R.id.uzsakymailist);
        infotext = (TextView) findViewById(R.id.txtresulttext);
        //cb1 = (CheckBox) findViewById(R.id.txtuzsakymoid);



        try {

            ArrayList<HashMap<String, String>> data = controller.getuzsakymas();
            if (data.size() != 0) {
                // Srno, RMCode, Fileno, Loc, FileDesc, TAGNos
                SimpleAdapter adapter = new SimpleAdapter(
                        UzsakymaiList.this, data, R.layout.uzsakymairows,
                        new String[]{"prekes"}, new int[]{
                        R.id.txtprekes});
                ls.setAdapter(adapter);

                //pazymetas = (CheckBox) findViewById(R.id.pazymeta);




                String length = String.valueOf(data.size());
                infotext.setText(length + " uzsakymai");
               // String[] from={"uzsakymoid","klientoid", "prekes", "suma"};//string array
             //   int[] to={ R.id.txtuzsakymoid, R.id.txtklientoid, R.id.txtprekes, R.id.txtsuma};//int array of views id's
             //   SimpleAdapter simpleAdapter=new SimpleAdapter(this,data,R.layout.uzsakymairows,from,to);//Create object and set the parameters for simpleAdapter
             //   ls.setAdapter(simpleAdapter);//sets the adapter for listView


            } else {
                infotext.setText("No data in database");
            }





        } catch (Exception ex) {
            infotext.setText(ex.getMessage().toString());

        }

      //  SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.uzsakymairows2,from,to);//Create object and set the parameters for simpleAdapter
     //   ls.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event



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

    private void DisplayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}