package com.example.kompas.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class naujapreke extends ActionBarActivity {
    PrekesDBController controller1 = new PrekesDBController(this);
    Button add, view, update, delete;
    EditText prekesid, pavadinimas, dydis, kaina ;
    TextView infotext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naujapreke);
        prekesid = (EditText) findViewById(R.id.edprekesid);
        pavadinimas = (EditText) findViewById(R.id.edpavadinimas );
        dydis = (EditText) findViewById(R.id.eddydis);
        kaina = (EditText) findViewById(R.id.edkaina);

        add = (Button) findViewById(R.id.btnadd);
        update = (Button) findViewById(R.id.btnupdate);
        delete = (Button) findViewById(R.id.btndelete);
        view = (Button) findViewById(R.id.btnview);
        infotext = (TextView) findViewById(R.id.txtresulttext);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(naujapreke.this, PrekesList.class);
                startActivity(i);
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (pavadinimas.getText().toString().trim().equals("") || kaina.getText().toString().trim().equals(""))   {
                        infotext.setText("Please insert place name and country..");
                    } else {
                        controller1 = new PrekesDBController(getApplicationContext());
                        SQLiteDatabase db = controller1.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("pavadinimas", pavadinimas.getText().toString());
                        cv.put("dydis", dydis.getText().toString());
                        cv.put("kaina", kaina.getText().toString());
                        db.insert("prekes1", null, cv);
                        db.close();
                        Intent intent = new Intent(getBaseContext(), PrekiuRedagavimas.class);
                        startActivity(intent);

                        infotext.setText("Place added Successfully");
                    }
                } catch (Exception ex) {
                    infotext.setText(ex.getMessage().toString());
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if ((pavadinimas.getText().toString().trim().equals("") && dydis.getText().toString().trim().equals("")) || kaina.getText().toString().trim().equals("")) {
                        infotext.setText("Please insert values to update..");
                    } else {
                        controller1 = new PrekesDBController(getApplicationContext());
                        SQLiteDatabase db = controller1.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("pavadinimas", pavadinimas.getText().toString());
                        cv.put("dydis", dydis.getText().toString());
                        cv.put("kaina", kaina.getText().toString());

                        db.update("prekes1", cv, "prekesid=" + prekesid.getText().toString(), null);

                        Toast.makeText(naujapreke.this,
                                "Updated successfully", Toast.LENGTH_SHORT)
                                .show();

                        infotext.setText("Updated Successfully");
                    }
                } catch (Exception ex) {
                    infotext.setText(ex.getMessage().toString());
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (prekesid.getText().toString().trim().equals("")) {
                        infotext.setText("Please insert place ID to delete..");
                    } else {
                        controller1 = new PrekesDBController(getApplicationContext());
                        SQLiteDatabase db = controller1.getWritableDatabase();

                        db.delete("prekes1", "prekesid=" + prekesid.getText().toString(), null);

                        Toast.makeText(naujapreke.this,
                                "deleted successfully", Toast.LENGTH_SHORT)
                                .show();
                        infotext.setText("Deleted Successfully");
                    }
                } catch (Exception ex) {
                    infotext.setText(ex.getMessage().toString());
                }
            }
        });
    }


    //   @Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    getMenuInflater().inflate(R.menu.menu_main, menu);
    //    return true;
    //      }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}