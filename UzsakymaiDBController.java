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

public class UzsakymaiDBController extends SQLiteOpenHelper {
    private static final String tablename = "uzsakymai2";  // tablename
    private static final String uzsakymoid = "uzsakymoid";  // auto generated ID column
    private static final String klientoid = "klientoid";  // column name
    private static final String prekes = "prekes"; // column name
    private static final String suma = "suma"; // column name
    private static final String databasename = "uzsakymaiinfo2"; // Dtabasename
    private static final int versioncode = 1; //versioncode of the database

    public UzsakymaiDBController(Context context) {
        super(context, databasename, null, versioncode);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE IF NOT EXISTS " + tablename + "(" + uzsakymoid + " integer primary key, " + klientoid + " text, " + prekes + " text, " + suma + " text)";
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
                map.put("uzsakymoid", cursor.getString(0));
                map.put("klientoid", cursor.getString(1));
                map.put("prekes", cursor.getString(2));
                map.put("suma", cursor.getString(3));

                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }
    public ArrayList<HashMap<String, String>> getuzsakymoid() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("uzsakymoid", cursor.getString(0));

                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }
    public ArrayList<HashMap<String, String>> getuzsakymas() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("prekes", cursor.getString(2));

                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }

}