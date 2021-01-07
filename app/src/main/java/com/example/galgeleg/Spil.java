package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Spil extends AppCompatActivity implements View.OnKeyListener {

    Galgelogik galgelogik = new Galgelogik();
    TextView tekst, navneView, wordToGuess;
    EditText input;
    Button GuessLetter;
    String spillerNavn, ordet;
    int point;
    int antalGaet = 0;
    int antalForkerteGaet = 0;


    /**
     * Instantierer en baggrundstråd og en maintråd (ui)
     */
//    Executor backgroundThread = Executors.newSingleThreadExecutor();
//    Handler uiThread = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        /**
         *  Sætter teksterne i de tre tekstviews, hhv opdatering på hvor ordene kommer fra, ordet der skal gættes og spillerens navn
         * */

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        Intent i = getIntent();
        spillerNavn = i.getStringExtra("spillerNavn");
        ordet = i.getStringExtra("valgtOrd");


        galgelogik.muligeOrd.clear();
        galgelogik.muligeOrd.add(ordet);


        System.out.println("skal være hejsa: " + galgelogik.muligeOrd);

        galgelogik.setOrdet(ordet);
        galgelogik.startNytSpil();
        galgelogik.logStatus();


        navneView = findViewById(R.id.nameView);
        navneView.setText("Hej ");
        navneView.append(spillerNavn);

        input = new EditText(this);
        input = findViewById(R.id.guessLetter);


        wordToGuess = (TextView) findViewById(R.id.wordToBeGuessed);
        wordToGuess.setText("Gæt ordet " + galgelogik.getSynligtOrd());
        point = galgelogik.getOrdet().length();


    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_A:
                System.out.println("trykkede på a");
                galgelogik.gætBogstav("a");
                updateView();

                return true;
            case KeyEvent.KEYCODE_B:
                System.out.println("trykkede på B");
                galgelogik.gætBogstav("b");
                updateView();

                return true;
            case KeyEvent.KEYCODE_C:
                System.out.println("trykkede på C");
                galgelogik.gætBogstav("c");
                updateView();

                return true;
            case KeyEvent.KEYCODE_D:
                System.out.println("trykkede på D");
                galgelogik.gætBogstav("d");
                updateView();

                return true;
            case KeyEvent.KEYCODE_E:
                System.out.println("trykkede på E");
                galgelogik.gætBogstav("e");
                updateView();

                return true;
            case KeyEvent.KEYCODE_F:
                System.out.println("trykkede på F");
                galgelogik.gætBogstav("f");
                updateView();

                return true;
            case KeyEvent.KEYCODE_G:
                System.out.println("trykkede på G");
                galgelogik.gætBogstav("g");
                updateView();

                return true;
            case KeyEvent.KEYCODE_H:
                System.out.println("trykkede på H");
                galgelogik.gætBogstav("h");
                updateView();

                return true;
            case KeyEvent.KEYCODE_I:
                System.out.println("trykkede på I");
                galgelogik.gætBogstav("i");
                updateView();

                return true;
            case KeyEvent.KEYCODE_J:
                System.out.println("trykkede på J");
                galgelogik.gætBogstav("j");
                updateView();

                return true;
            case KeyEvent.KEYCODE_K:
                System.out.println("trykkede på K");
                galgelogik.gætBogstav("k");
                updateView();

                return true;
            case KeyEvent.KEYCODE_L:
                System.out.println("trykkede på L");
                galgelogik.gætBogstav("l");
                updateView();

                return true;
            case KeyEvent.KEYCODE_M:
                System.out.println("trykkede på M");
                galgelogik.gætBogstav("m");
                updateView();

                return true;
            case KeyEvent.KEYCODE_N:
                System.out.println("trykkede på N");
                galgelogik.gætBogstav("n");
                updateView();

                return true;
            case KeyEvent.KEYCODE_O:
                System.out.println("trykkede på O");
                galgelogik.gætBogstav("o");
                updateView();

                return true;
            case KeyEvent.KEYCODE_P:
                System.out.println("trykkede på P");
                galgelogik.gætBogstav("p");
                updateView();

                return true;
            case KeyEvent.KEYCODE_Q:
                System.out.println("trykkede på Q");
                galgelogik.gætBogstav("q");
                updateView();

                return true;
            case KeyEvent.KEYCODE_R:
                System.out.println("trykkede på R");
                galgelogik.gætBogstav("r");
                updateView();

                return true;
            case KeyEvent.KEYCODE_S:
                System.out.println("trykkede på S");
                galgelogik.gætBogstav("s");
                updateView();

                return true;
            case KeyEvent.KEYCODE_T:
                System.out.println("trykkede på T");
                galgelogik.gætBogstav("t");
                updateView();

                return true;
            case KeyEvent.KEYCODE_U:
                System.out.println("trykkede på U");
                galgelogik.gætBogstav("u");
                updateView();

                return true;
            case KeyEvent.KEYCODE_V:
                System.out.println("trykkede på V");
                galgelogik.gætBogstav("v");
                updateView();

                return true;
            case KeyEvent.KEYCODE_W:
                System.out.println("trykkede på W");
                galgelogik.gætBogstav("w");
                updateView();

                return true;
            case KeyEvent.KEYCODE_X:
                System.out.println("trykkede på X");
                galgelogik.gætBogstav("x");
                updateView();

                return true;
            case KeyEvent.KEYCODE_Y:
                System.out.println("trykkede på Y");
                galgelogik.gætBogstav("y");
                updateView();

                return true;
            case KeyEvent.KEYCODE_Z:
                System.out.println("trykkede på Z");
                galgelogik.gætBogstav("z");
                updateView();

                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }




    private void didTheyWin() {

        if (galgelogik.erSpilletVundet()) {
            navneView.setText("Yes, du vandt!");

            Intent intent = new Intent(this, Vundet.class);
            intent.putExtra("spillerNavn", spillerNavn);
            intent.putExtra("point", point);
            intent.putExtra("antalGaet", antalGaet);
            this.startActivity(intent);
        }
    }

    private void didTheyLose() {
        if (galgelogik.erSpilletTabt()) {
            navneView.setText("Pis, du har tabt");
            Intent intent = new Intent(this, Tabt.class);
            intent.putExtra("wordToGuess", galgelogik.getOrdet());
            this.startActivity(intent);
        }
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//        input.getText().clear();
        if (keyCode == 66 && KeyEvent.ACTION_DOWN == keyEvent.getAction()) {
//             input.setText("");

            System.out.println("trykkede på enter");
            String bogstav = input.getText().toString();
            System.out.println(bogstav);
            antalGaet = antalGaet + 1;
            galgelogik.gætBogstav(bogstav);

            if (galgelogik.erSidsteBogstavKorrekt()) {

                YoYo.with(Techniques.Flash)
                        .duration(700)
                        .repeat(1)
                        .playOn(wordToGuess);
                navneView.setText("Juhu, du gættede et bogstav korrekt!");
                didTheyWin();
                wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());
                System.out.println("gæt ordet: " + galgelogik.getSynligtOrd() + galgelogik.getOrdet());


            } else {
                YoYo.with(Techniques.Wobble)
                        //  YoYo.with(Techniques.Flash)
                        .duration(700)
                        .repeat(1)
                        .playOn(wordToGuess);
                navneView.setText("Æv, det var ikke rigtigt. Prøv igen.\n");
                didTheyLose();
            }
            navneView.append("\nDu har " + galgelogik.getAntalForkerteBogstaver() + " forkerte.\n"
                    + "og du har gættet på " + galgelogik.getBrugteBogstaver());
            System.out.println(galgelogik.getAntalForkerteBogstaver());


        }
        return false;
    }

    public void updateView(){
        antalGaet = antalGaet + 1;
        if (galgelogik.erSidsteBogstavKorrekt()) {

            YoYo.with(Techniques.Flash)
                    .duration(700)
                    .repeat(1)
                    .playOn(wordToGuess);
            navneView.setText("Juhu, du gættede et bogstav korrekt!");
            didTheyWin();
            wordToGuess.setText("Du skal gætte ordet " + galgelogik.getSynligtOrd());
            System.out.println("gæt ordet: " + galgelogik.getSynligtOrd() + galgelogik.getOrdet());


        } else {
            YoYo.with(Techniques.Wobble)
                    //  YoYo.with(Techniques.Flash)
                    .duration(700)
                    .repeat(1)
                    .playOn(wordToGuess);
            navneView.setText("Æv, det var ikke rigtigt. Prøv igen.\n");
            antalForkerteGaet++;
            wrongGuess();
            didTheyLose();
        }
        navneView.append("\nDu har " + galgelogik.getAntalForkerteBogstaver() + " forkerte.\n"
                + "og du har gættet på " + galgelogik.getBrugteBogstaver());
        System.out.println(galgelogik.getAntalForkerteBogstaver());

    }


    public void wrongGuess(){

    }

}