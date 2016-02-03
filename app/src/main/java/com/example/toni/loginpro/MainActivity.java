package com.example.toni.loginpro;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText etnick, etpunt;

    private LoginHelper loginHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnick = (EditText) findViewById(R.id.etnick);
        etpunt = (EditText) findViewById(R.id.etpunt);

        loginHelper = new LoginHelper(getApplicationContext(), "usuarios", null, 1);
    }

    public void meteme(View v) {

        ContentValues valuesToStore = new ContentValues();
        valuesToStore.put("nick", etnick.getText().toString());
        valuesToStore.put("puntuacion", Integer.parseInt(etpunt.getText().toString()));
        loginHelper.createPlayer(valuesToStore, "jugadores");

        Toast.makeText(getApplicationContext(), "Usuario añadido", Toast.LENGTH_SHORT).show();
        etnick.setText("");
        etpunt.setText("");
    }

    public void ves(View v) {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }
}
