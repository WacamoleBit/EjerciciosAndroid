package com.example.ejercicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CancionesHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATA_BASE = "canciones.db";
    public static final String SQL_CREATE_CANCIONES =
            "CREATE TABLE " + CancionesContract.CancionesTab.TABLE_NAME +
                    " (" + CancionesContract.CancionesTab._ID + " INTEGER PRIMARY KEY," +
                    CancionesContract.CancionesTab.COLUMN_TITULO + " TEXT," +
                    CancionesContract.CancionesTab.COLUMN_CANTANTE + " TEXT);";
    public static final String SQL_DELETE_CANCIONES =
            "DROP TABLE IF EXISTS " + CancionesContract.CancionesTab.TABLE_NAME;

    public CancionesHelper(Context context) {
        super(context, DATA_BASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CANCIONES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_CANCIONES);
        onCreate((sqLiteDatabase));
    }
}
