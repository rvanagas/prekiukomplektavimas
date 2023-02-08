package com.example.kompas.myapplication;

/**
 * Created by Kompas on 2017.03.13.
 */

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump extends Activity {


    public  HashMap<String, List<String>> getData() {

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

        List<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, pavadinimas);



        List<String> cricket = new ArrayList<String>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");


        List<String> football = new ArrayList<String>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands");
        football.add("Italy");

        List<String> basketball = new ArrayList<String>();
        basketball.add("United States");
        basketball.add("Spain");
        basketball.add("Argentina");
        basketball.add("France");
        basketball.add("Russia");

        expandableListDetail.put("CRICKET TEAMS", cricket);
        expandableListDetail.put("FOOTBALL TEAMS", football);
        expandableListDetail.put("BASKETBALL TEAMS", basketball);

        return expandableListDetail;

    }


}
