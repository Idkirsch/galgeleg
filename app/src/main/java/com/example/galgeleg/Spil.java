package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Spil extends AppCompatActivity implements View.OnClickListener {

    Galgelogik galgelogik = new Galgelogik();
    TextView tekst, navneView;
    Button A, B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);
        Intent i = getIntent();


        System.out.println("Log");

        tekst = (TextView) findViewById(R.id.textView);
        tekst.setText("Du skal gætte Ordet: " + galgelogik.getSynligtOrd());

        navneView = (TextView) findViewById(R.id.nameView);
        String navn2 = i.getStringExtra("spillerNavn");
        System.out.println(navn2);
        navneView.setText("Hej "+ navn2);
      //  navn.append(i.getStringExtra("name"));


        //husk at caste
        A = new Button(this);
        A = (Button) findViewById(R.id.buttonA);
        A.setOnClickListener(this);

        B = new Button(this);
        B = (Button) findViewById(R.id.buttonB);
        B.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == A){
            System.out.println("Trykkede på knap A");
            //galgelogik.gætBogstav("A");
        }else if(v == B){
            System.out.println("Trykkede på knap B");
        }
    }
}