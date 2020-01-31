package com.example.fragaria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class AdatbazisSegito extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME ="fragaria";
    public static  final String TABLE_NAME = "user";
    public static  final String TABLE_NAME1 = "noveny";


    //user tablahoz tartozo mezok
    public  static  final String COL_1 = "ID";
    public  static  final String COL_2 = "email";
    public  static  final String COL_3 = "jelszo";
    public  static  final String COL_4 = "valasztottNovenyID";
    // noneny tablahoz tartozo mezok
    public  static  final String COL_5 = "novenyID";
    public  static  final String COL_6 = "nev"; //latin-magyar
    public  static  final String COL_7 = "leiras";
    public  static  final String COL_8 = "aktualisSzint";
    public  static  final String COL_9 = "maxSzint";



    public AdatbazisSegito(Context context)
    {
        super(context,DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + "ID" + " integer primary key autoincrement, "
                + "email" + " text not null, "
                + "jelszo" + " text not null, "
                + "valasztottNovenyID" + " integer,"
                + " FOREIGN KEY ("+"valasztottNovenyID"+") REFERENCES "+TABLE_NAME1+"("+"novenyID"+"));");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME1 + " ("
                + "novenyID" + " integer primary key autoincrement, "
                + "nev" + " text not null, "
                + "leiras" + " text not null, "
                + "aktualisSzint" + " integer, "
                + "maxSzint" + "integer not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }

    public boolean adatFelvetel(String email, String jelszo, String valasztottNovenyID)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,jelszo);
        contentValues.put(COL_4, valasztottNovenyID);
        Long eredmeny = database.insert(TABLE_NAME, null,contentValues);
        if (eredmeny == -1)
            return false;
        else
            return  true;
    }
    public boolean novenyFelvetel(String nev, String leiras, String aktualisSzint, String maxSzint)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6, nev);
        contentValues.put(COL_7, leiras);
        contentValues.put(COL_8, aktualisSzint);
        contentValues.put(COL_9, maxSzint);

        Long eredmeny = database.insert(TABLE_NAME1, null,contentValues);
        if (eredmeny == -1)
            return false;
        else
            return  true;
    }
    public Cursor adatLekerdezes()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * from " + TABLE_NAME, null);
        return eredmeny;

    }
    public boolean emailEsJelszoEllenorzes(String email ,String jelszo)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from "+ TABLE_NAME +" where email=? or jelszo=?", new String[]{email,jelszo});
        if (cursor.getCount()>0)
            return  true;
        else  return false;
    }

}
