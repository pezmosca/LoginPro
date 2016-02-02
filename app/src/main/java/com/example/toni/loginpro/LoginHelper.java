package com.example.toni.loginpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Toni on 02/02/2016.
 */
public class LoginHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "usuarios";
    public static final String PLAYERS_TABLE = "jugadores";
    public static final String PLAYERS_TABLE_CREATE = "CREATE TABLE " + PLAYERS_TABLE + "(nick TEXT PRIMARY KEY UNIQUE, puntuacion INTEGER)";

    public LoginHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PLAYERS_TABLE_CREATE);
    }

    public Cursor getAllPlayers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select nick from " + PLAYERS_TABLE, null);
        return c;
    }

    public Cursor getAllPlayersPunt() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select nick, puntuacion from " + PLAYERS_TABLE, null);
        return c;
    }

    public void createPlayer(ContentValues values, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tableName, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
