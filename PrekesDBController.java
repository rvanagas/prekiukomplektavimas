package com.example.kompas.myapplication;

/**
 * Created by abc on 20-May-15.
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class PrekesDBController extends SQLiteOpenHelper {
    private static final String tablename = "prekes1";  // tablename
    private static final String prekesid = "prekesid";  // auto generated ID column
    private static final String pavadinimas = "pavadinimas";  // column name
    private static final String dydis = "dydis"; // column name
    private static final String kaina = "kaina"; // column name
    private static final String databasename = "prekesinf"; // Dtabasename
    private static final int versioncode = 1; //versioncode of the database

    public PrekesDBController(Context context) {
        super(context, databasename, null, versioncode);

    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE IF NOT EXISTS " + tablename + "(" + prekesid + " integer primary key, " + pavadinimas + " text, " + dydis + " text, " + kaina + " text)";
        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old,
                          int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS " + tablename;
        database.execSQL(query);
        onCreate(database);
    }

    public ArrayList<HashMap<String, String>> getAllPlace() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("prekesid", cursor.getString(0));
                map.put("pavadinimas", cursor.getString(1));
                map.put("dydis", cursor.getString(2));
                map.put("kaina", cursor.getString(3));

                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }
    public ArrayList<HashMap<String, String>> getpavadinimas() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("pavadinimas", cursor.getString(1));


                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }
    public ArrayList<HashMap<String, String>> getid() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("prekesid", cursor.getString(0));


                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }

    public int getSuma() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("prekesid", cursor.getString(0));


                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return cursor.getInt(0);
    }



    public ArrayList<HashMap<String, String>> getprekes() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("prekesid", cursor.getString(0));
                map.put("pavadinimas", cursor.getString(1));


                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }

}