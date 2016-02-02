package com.example.toni.loginpro;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText etnick, etpunt;

    private LoginHelper loginHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnick = (EditText) findViewById(R.id.etnick);
        etpunt = (EditText) findViewById(R.id.etpunt);

        loginHelper = new LoginHelper(getApplicationContext());
    }

    public void meteme(View v) {
        ContentValues valuesToStore = new ContentValues();
        valuesToStore.put("nick", String.valueOf(etnick.getText()));
        valuesToStore.put("puntuacion", String.valueOf(etpunt.getText()));

        LoginHelper.createPlayer(valuesToStore, "jugadores");
    }
}
