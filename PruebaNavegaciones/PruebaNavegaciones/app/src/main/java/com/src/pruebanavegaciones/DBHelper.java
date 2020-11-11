package com.src.pruebanavegaciones;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="DevAndroid.db";

    public DBHelper(Context context) {
        super(context, "DevAndroid.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table usuario(codigo integer primary key AUTOINCREMENT, nombre text, apellido text, fecNac text, sexo text," +
                " correo text, telefono int, distrito text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists usuario");
    }

    public Boolean insertData(String nombre, String apellido, String fecNac , String sexo ,
                              String correo, String telefono, String distrito, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        cv.put("apellido", apellido);
        cv.put("fecNac", fecNac);
        cv.put("sexo", sexo);
        cv.put("correo", correo);
        cv.put("telefono", telefono);
        cv.put("distrito", distrito);
        cv.put("password", password);
        long result= db.insert("usuario", null, cv);
        if (result==-1)return false;
        else
            return true;
    }

    public Boolean user(String correo){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from usuario where correo =?", new String[] {correo});
        if (c.getCount()>0)
            return true;
        else
            return false;
    }

    public String userpass(String correo, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select nombre from usuario where correo =? and password = ?", new String[] {correo, password});
        c.moveToFirst();
        return c.getCount()>0 ? c.getString(0) : "";
    }
}
