package com.example.kompas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Kompas on 2017.01.16.
 */

public class apie extends Activity {
    PrekesDBController controller = new PrekesDBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.apie);
        List<HashMap<String, String>> data = controller.getAllPlace();
        int prekiuskaicius = data.size();
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText((Integer.toString(prekiuskaicius)), TextView.BufferType.EDITABLE);
        HashMap<String, List<String>> superlistas11 = ListViewCheckboxesActivity.getsuperlistas();
        int uzsakymuskaicius = superlistas11.size();
        EditText editText1 = (EditText)findViewById(R.id.editText3);
        editText1.setText((Integer.toString(uzsakymuskaicius)), TextView.BufferType.EDITABLE);

    }
}



