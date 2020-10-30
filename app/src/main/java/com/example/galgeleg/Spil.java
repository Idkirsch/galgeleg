package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Spil extends AppCompatActivity implements View.OnClickListener {

    Galgelogik galgelogik = new Galgelogik();
    TextView tekst, navneView, wordToGuess;
    EditText input;
    Button GuessLetter;
  /**
   * Instantierer en baggrundstråd og en maintråd (ui)
   * */
    Executor backgroundThread = Executors.newSingleThreadExecutor();
    Handler uiThread = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);
        Intent i = getIntent();

        /**
         *  Sætter teksterne i de tre tekstviews, hhv opdatering på hvor ordene kommer fra, ordet der skal gættes og spillerens navn
         * */
        tekst = (TextView) findViewById(R.id.textView);
       // tekst.setText("Henter ord fra DRs server ");
        tekst.setText("Tab og vind med samme sind ");

        wordToGuess = (TextView) findViewById(R.id.wordToBeGuessed);
        wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());


        navneView = findViewById(R.id.nameView);
        System.out.println(i.getStringExtra("spillerNavn"));
        navneView.setText("Hej og velkommen til ");
        navneView.append(i.getStringExtra("spillerNavn"));

        /**
         * Knappen hvor man gætter et bogstav instantieres
         * Inputfeltet hvor brugeren taster sit gæt instantieres
         * */

        GuessLetter = new Button(this);
        GuessLetter = (Button) findViewById(R.id.buttonGuess);
        GuessLetter.setOnClickListener(this);

        input = new EditText(this);
        input = findViewById(R.id.input);
        input.setOnClickListener(this);

        /**
         * Der oprettes en baggrundstråd som henter nogle ord fra DR
         * Teksten på skærmen opdateres med en meddelelse om det lykkedes eller ej
         * */
/*
        backgroundThread.execute(() ->{
          try {
              galgelogik.hentOrdFraDr();
              uiThread.post(() -> {
                  tekst.setText("Ordene blev korrekt hentet");
              });
          }catch (Exception e){
              e.printStackTrace();
              uiThread.post(() -> {
                  tekst.setText("Ordene blev ikke hentet korretk" +e);
              });
          }
        });
*/

    }

    @Override
    public void onClick(View v) {
        if (v == GuessLetter) {
            String bogstav = input.getText().toString();
            System.out.println("Trykkede på knap: gæt bogstav");
            if (bogstav.length() == 1) {
                galgelogik.gætBogstav(bogstav);
                if (galgelogik.erSidsteBogstavKorrekt()) {
                    navneView.setText("Juhu, du gættede et bogstav korrekt!");
                    didTheyWin();
                    wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());
                } else {
                    navneView.setText("Æv, det var ikke rigtigt. Prøv igen.\n");
                    didTheyLose();
                }
                navneView.append("\nDu har " + galgelogik.getAntalForkerteBogstaver() + " forkerte.\n"
                        +"og du har gættet på "+ galgelogik.getBrugteBogstaver());
                System.out.println(galgelogik.getAntalForkerteBogstaver());
            } else {
                navneView.setText("Du skal gætte på nøjagtig ét bogstav\n"); }
            input.setText("");
        }
    }

    private void didTheyWin(){

            if(galgelogik.erSpilletVundet()){
                navneView.setText("Yes, du vandt!");
                Intent intent = new Intent(this, Vundet.class);
                this.startActivity(intent);
            }
    }

    private void didTheyLose(){
        if(galgelogik.erSpilletTabt()){
            navneView.setText("Pis, du har tabt");
            Intent intent = new Intent(this, Tabt.class);
            this.startActivity(intent);
        }
    }

}