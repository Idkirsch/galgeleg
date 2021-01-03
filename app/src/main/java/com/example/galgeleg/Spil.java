package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Spil extends AppCompatActivity implements View.OnClickListener {

    Galgelogik galgelogik = new Galgelogik();
    //HentOrd hentOrd = new HentOrd();
    TextView tekst, navneView, wordToGuess;
    EditText input;
    Button GuessLetter;
    String spillerNavn, ordet;
    int point;
    int antalGaet = 0;


  /**
   * Instantierer en baggrundstråd og en maintråd (ui)
   * */
//    Executor backgroundThread = Executors.newSingleThreadExecutor();
//    Handler uiThread = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        /**
         *  Sætter teksterne i de tre tekstviews, hhv opdatering på hvor ordene kommer fra, ordet der skal gættes og spillerens navn
         * */
        tekst = (TextView) findViewById(R.id.textView);
        tekst.setText("Tab og vind med samme sind ");


        //spillerNavn bliver sendt videre vha intents indbyggede funktionalitet
        Intent i = getIntent();
        spillerNavn = i.getStringExtra("spillerNavn");
        ordet = i.getStringExtra("valgtOrd");
        System.out.println(spillerNavn);
        System.out.println(ordet);

        galgelogik.logStatus();


        galgelogik.muligeOrd.clear();
        galgelogik.muligeOrd.add(ordet);


        System.out.println("skal være hejsa: "+ galgelogik.muligeOrd);

        galgelogik.setOrdet(ordet);
        galgelogik.startNytSpil();
        galgelogik.logStatus();




        navneView = findViewById(R.id.nameView);
        navneView.setText("Hej og velkommen til ");
        navneView.append(spillerNavn);


        GuessLetter = new Button(this);
        GuessLetter = (Button) findViewById(R.id.buttonGuess);
        GuessLetter.setOnClickListener(this);

        input = new EditText(this);
        input = findViewById(R.id.input);
        input.setOnClickListener(this);


        wordToGuess = (TextView) findViewById(R.id.wordToBeGuessed);
        wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());
        point = galgelogik.getOrdet().length();

        /**
         * Der oprettes en baggrundstråd som henter nogle ord fra DR
         * Teksten på skærmen opdateres med en meddelelse om det lykkedes eller ej
         * */

//        backgroundThread.execute(() ->{
//          try {
//              hentOrdFraDr();
//              uiThread.post(() -> {
//                  System.out.println("Ord blev hentet fra DRs server");
//
//                  wordToGuess = (TextView) findViewById(R.id.wordToBeGuessed);
//                  wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());
//
//                  point = galgelogik.getSynligtOrd().length();
//                  System.out.println("point: "+point);
//
//              });
//          }catch (Exception e){
//              e.printStackTrace();
//          }
//        });

    }

    @Override
    public void onClick(View v) {
        if (v == GuessLetter) {
            String bogstav = input.getText().toString();
            System.out.println("Trykkede på knap: gæt bogstav");
            antalGaet = antalGaet+1;
            System.out.println("antal gæt : " + antalGaet);
            if (bogstav.length() == 1) {
                galgelogik.gætBogstav(bogstav);
                if (galgelogik.erSidsteBogstavKorrekt()) {
                    navneView.setText("Juhu, du gættede et bogstav korrekt!");
                    didTheyWin();
                   wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());
                    System.out.println("gæt ordet: " +galgelogik.getSynligtOrd() + galgelogik.getOrdet());
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
        }else if (v == input){
            System.out.println("klikkede på inputfelt");
        }
    }

    private void didTheyWin(){

            if(galgelogik.erSpilletVundet()){
                navneView.setText("Yes, du vandt!");

                Intent intent = new Intent(this, Vundet.class);
                intent.putExtra("spillerNavn", spillerNavn);
                intent.putExtra("point", point);
                intent.putExtra("antalGaet", antalGaet);
                this.startActivity(intent);
            }
    }

    private void didTheyLose(){
        if(galgelogik.erSpilletTabt()){
            navneView.setText("Pis, du har tabt");
            Intent intent = new Intent(this, Tabt.class);
            intent.putExtra("wordToGuess", galgelogik.getOrdet());
            this.startActivity(intent);
        }
    }

}