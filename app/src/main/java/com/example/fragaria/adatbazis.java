/*package com.example.fragaria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class adatbazis extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "fragaria.DB"; //adatbazis neve
    public static final String TABLE_NAME="NOVENY";         //tábla neve

    public static final String COL_1="ID";                  //első oszlop
    public static final String COL_2="LATIN_NEV";           //második oszlop
    public static final String COL_3="MAGYAR_NEV";          //harmadik oszlop
    public static final String COL_4="IDOSZAK";             //negyedik oszlop
    public static final String COL_5="LEIRAS";              //ötödik oszlop
    public static final String COL_6="MERGEZO";             //hatodik oszlop
    public static final String COL_7="FELHASZNALAS";        //hetedik oszlop

    public adatbazis(Context context) {
        super(context, DATABASE_NAME, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,LATIN_NEV TEXT,MAGYAR_NEV TEXT,IDOSZAK TEXT,LEIRAS TEXT,MERGEZO TEXT,FELHASZNALAS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public boolean adatRogzites(String latinnev, String magyarnev, String idoszak,String leiras,String mergezo,String felhasznalas){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, latinnev);
        contentValues.put(COL_3, magyarnev);
        contentValues.put(COL_4, idoszak);
        contentValues.put(COL_5, leiras);
        contentValues.put(COL_6, mergezo);
        contentValues.put(COL_7, felhasznalas);

        long eredmeny = database.insert(TABLE_NAME,null,contentValues);
        if (eredmeny==-1)
            return false;       //sikertelen felvetel eseten false eredmény kapunk
        else
            return true;
    }
    public Cursor adatLekerdezes(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return eredmeny;
    }
    public long adatTorles(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME,COL_1+" = ?",new String[] {String.valueOf(id)});
    }

    public long adatModosit(String id,String latinnev, String magyarnev, String idoszak,String leiras,String mergezo,String felhasznalas){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, latinnev);
        values.put(COL_3, magyarnev);
        values.put(COL_4, idoszak);
        values.put(COL_5, leiras);
        values.put(COL_6, mergezo);
        values.put(COL_7, felhasznalas);
        return  database.update(TABLE_NAME, values, COL_1+" = ?", new String[]{id});
    }
}
*/

package com.example.fragaria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class adatbazis extends SQLiteOpenHelper {


    public  static final String DATABASE_NAME= "LogRegAdatbazis.db";
    public static final String TABLE_NAME="felhasznalo";

    public static final String COL_1="id";
    public static final String COL_2="email";
    public static final String COL_3="jelszo";
    public adatbazis(Context context) {
        super(context, DATABASE_NAME, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "email TEXT NOT NULL," + "jelszo TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public boolean adatRogzites(String email, String jelszo){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, jelszo);

        long eredmeny = database.insert(TABLE_NAME,null,contentValues);
        if (eredmeny==-1)
            return false;
        else
            return true;
    }
    public Cursor bejeletkezes(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return eredmeny;
    }
}
