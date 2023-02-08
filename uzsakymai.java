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

public class uzsakymai extends ActionBarActivity {
    UzsakymaiDBController controller = new UzsakymaiDBController(this);
    Button add, view, update, delete;
    EditText uzsakymoid, klientoid, prekes, suma ;
    TextView infotext;
    boolean selected = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uzsakymai);


        uzsakymoid = (EditText) findViewById(R.id.eduzsakymoid);
        klientoid = (EditText) findViewById(R.id.edklientoid );
        prekes = (EditText) findViewById(R.id.edprekes);
        suma = (EditText) findViewById(R.id.edsuma);

        add = (Button) findViewById(R.id.btnadd);
        update = (Button) findViewById(R.id.btnupdate);
        delete = (Button) findViewById(R.id.btndelete);
        view = (Button) findViewById(R.id.btnview);
        infotext = (TextView) findViewById(R.id.txtresulttext);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(uzsakymai.this, UzsakymaiList.class);
                startActivity(i);
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (prekes.getText().toString().trim().equals("") || klientoid.getText().toString().trim().equals(""))   {
                        infotext.setText("Please insert place name and country..");
                    } else {
                        controller = new UzsakymaiDBController(getApplicationContext());
                        SQLiteDatabase db = controller.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("klientoid", klientoid.getText().toString());
                        cv.put("prekes", prekes.getText().toString());
                        cv.put("suma", suma.getText().toString());
                        db.insert("uzsakymai", null, cv);
                        db.close();
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
                    if ((prekes.getText().toString().trim().equals("") && klientoid.getText().toString().trim().equals("")) || prekes.getText().toString().trim().equals("")) {
                        infotext.setText("Please insert values to update..");
                    } else {
                        controller = new UzsakymaiDBController(getApplicationContext());
                        SQLiteDatabase db = controller.getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("klientoid", klientoid.getText().toString());
                        cv.put("prekes", prekes.getText().toString());
                        cv.put("suma", suma.getText().toString());

                        db.update("uzsakymai", cv, "uzsakymoid=" + uzsakymoid.getText().toString(), null);

                        Toast.makeText(uzsakymai.this,
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
                    if (uzsakymoid.getText().toString().trim().equals("")) {
                        infotext.setText("Please insert place ID to delete..");
                    } else {
                        controller = new UzsakymaiDBController(getApplicationContext());
                        SQLiteDatabase db = controller.getWritableDatabase();

                        db.delete("uzsakymai", "uzsakymoid=" + uzsakymoid.getText().toString(), null);

                        Toast.makeText(uzsakymai.this,
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
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
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