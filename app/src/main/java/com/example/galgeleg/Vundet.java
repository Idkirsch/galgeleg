package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vundet extends AppCompatActivity implements View.OnClickListener {

    Button nytspil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vundet);


        nytspil = (Button) findViewById(R.id.NytSpilVundet);
        nytspil.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        System.out.println("Det blev klikket på spil igen knappen, vinderskærm");

        if(view == nytspil){
           //TODO: Nice hvis spillernavnet følger med intents og så kan man ryge direkte ind i spillet igen med samme navn

            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

    }

}