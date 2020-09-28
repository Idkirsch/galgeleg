package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playGame;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playGame = findViewById(R.id.button);
        playGame.setOnClickListener(this);

        name = findViewById(R.id.name);


    }

    public void onClick(View v){
        if(v == playGame){
            Intent intent = new Intent(this, Spil.class);
            intent.putExtra("spillerNavn", "Spiller1");
            this.startActivity(intent);
        }
    }
}