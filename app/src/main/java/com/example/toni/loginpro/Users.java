package com.example.toni.loginpro;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Users extends AppCompatActivity {

    TextView tv1;
    LoginHelper loginHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        tv1 = (TextView) findViewById(R.id.tv1);

        loginHelper = new LoginHelper(this, "usuarios", null, 1);

        Cursor fila = loginHelper.getAllPlayers();

        if(fila.moveToFirst()) {
            Log.v("act","first one : " + fila.getString(fila.getColumnIndex("nick")));
            tv1.setText(fila.getString(fila.getColumnIndex("nick")) + "\n" + "hola");
        }
    }
}
