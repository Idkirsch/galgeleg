package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playGame, highscore;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playGame = findViewById(R.id.startSpil);
        playGame.setOnClickListener(this);

        name = findViewById(R.id.name);

        loadFragment(new highscore_frag());

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.highscore_frag, fragment, fragment.getClass().getSimpleName()).commit();
    }

    public void onClick(View v){
        if(v == playGame){
            String n = name.getText().toString();
            System.out.println(n);
            Intent intent = new Intent(this, Spil.class);
            intent.putExtra("spillerNavn", n);
            if(n.length() > 0){
                this.startActivity(intent);
            }else{
                name.setHint("Husk at skrive et navn");
            }
//
//        }else if(v == highscore){
//
//
//            System.out.println("Der blev trykket på highscore");
        }else if(v == name){
            System.out.println("trykkede på navnefelt");
        }
    }
}