package com.example.kompas.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import static com.example.kompas.myapplication.R.id.txtprekesid;


public class PrekesList extends ActionBarActivity {
    PrekesDBController controller = new PrekesDBController(this);
    ListView ls;
    TextView infotext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prekeslist);
        // delete = (Button) findViewById(R.id.btndel);
        ls = (ListView) findViewById(R.id.prekeslist);
        infotext = (TextView) findViewById(R.id.txtresulttext);



        try {
            List<HashMap<String, String>> data = controller.getAllPlace();
            if (data.size() != 0) {
                // Srno, RMCode, Fileno, Loc, FileDesc, TAGNos
                SimpleAdapter adapter = new SimpleAdapter(
                        PrekesList.this, data, R.layout.prekesrows,
                        new String[]{"prekesid", "pavadinimas", "dydis", "kaina"}, new int[]{
                        R.id.txtprekesid,
                        R.id.txtpavadinimas, R.id.txtdydis, R.id.txtkaina});
                ls.setAdapter(adapter);
                String length = String.valueOf(data.size());
                infotext.setText(length + " prekes");
            } else {
                infotext.setText("No data in database");
            }

        } catch (Exception ex) {
            infotext.setText(ex.getMessage().toString());
        }





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



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}