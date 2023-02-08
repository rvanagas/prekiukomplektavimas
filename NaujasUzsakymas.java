package com.example.kompas.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NaujasUzsakymas extends ActionBarActivity {
    UzsakymaiDBController controller = new UzsakymaiDBController(this);
    Button add, view, prideti, update, delete;
    EditText uzsakymoid, klientoid, prekes, suma ;
    TextView infotext;
    boolean selected = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naujasuzsakymas);



        klientoid = (EditText) findViewById(R.id.edklientoid );
        suma = (EditText) findViewById(R.id.edsuma);
        prideti = (Button) findViewById(R.id.edprekes);
        infotext = (TextView) findViewById(R.id.txtresulttext);




        prideti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NaujasUzsakymas.this, NaujasUzsakymasList.class);
                startActivity(i);

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
}