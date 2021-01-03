package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tabt extends AppCompatActivity implements View.OnClickListener {

    Button forfra;
    String ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt);

        Intent i = getIntent();
        ord = i.getStringExtra("wordToGuess");
        System.out.println("tabt :-( ... ordet var: "+ ord);

        forfra = (Button) findViewById(R.id.genstartTaber);
        forfra.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == forfra){
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
    }
}