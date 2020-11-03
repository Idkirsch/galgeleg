package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class Vundet extends AppCompatActivity implements View.OnClickListener {

    Button nytspil, gemScore;
    TextView tillykke;
    SharedPreferences prefMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vundet);

        prefMan = PreferenceManager.getDefaultSharedPreferences(this);
        String spillernavn = prefMan.getString("spillernavn", "ingen gemt tekst");
        System.out.println("spillernavn: "+ spillernavn);

        tillykke = (TextView) findViewById(R.id.Tillyke);
        tillykke.append(" "+ spillernavn + ", du har vundet!");

        nytspil = (Button) findViewById(R.id.NytSpilVundet);
        nytspil.setOnClickListener(this);

        gemScore = (Button) findViewById(R.id.GemHighscore);
        gemScore.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        System.out.println("Det blev klikket på spil igen knappen, vinderskærm");

        if(view == nytspil){
           //TODO: Nice hvis spillernavnet følger med intents og så kan man ryge direkte ind i spillet igen med samme navn

            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
        if(view == gemScore){
            System.out.println("der blev trykket på gem highscore knappen");
            //saveScore();
        }
    }

/* Det her kan måske bruges senere til at gemme highscore i json format

    private void saveScore(){
        prefMan = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefMan.edit();
        Gson gson = new Gson();
        String json = gson.toJson()

    }

 */
}