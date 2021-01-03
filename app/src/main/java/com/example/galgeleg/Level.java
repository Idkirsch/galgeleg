package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level extends AppCompatActivity implements View.OnClickListener {

    Button videre;
    String spillerNavn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        videre = (Button) findViewById(R.id.knap_til_spil);
        videre.setOnClickListener(this);

        Intent i = getIntent();
        spillerNavn = i.getStringExtra("spillerNavn");

    }


    @Override
    public void onClick(View view) {
        if(view == videre){
            Intent intent = new Intent(this, Spil.class);
            intent.putExtra("spillerNavn", spillerNavn);
            this.startActivity(intent);
        }
    }
}