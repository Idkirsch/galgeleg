package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Level extends AppCompatActivity implements View.OnClickListener {

    Button videre;
    String spillerNavn;
    HentOrd hentOrd = new HentOrd();


    Executor backgroundThread = Executors.newSingleThreadExecutor();
    Handler uiThread = new Handler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        videre = (Button) findViewById(R.id.knap_til_spil);
        videre.setOnClickListener(this);

        Intent i = getIntent();
        spillerNavn = i.getStringExtra("spillerNavn");

        backgroundThread.execute(() ->{
            try {
                hentOrd.hentOrdFraDr();
                uiThread.post(() -> {
                    System.out.println("Ord blev hentet fra DRs server");

                });
            }catch (Exception e){
                e.printStackTrace();
            }
        });


        hentOrd.galgelogik.logStatus();


    }


    @Override
    public void onClick(View view) {
        if(view == videre){
            Intent intent = new Intent(this, Spil.class);
            intent.putExtra("spillerNavn", spillerNavn);
            intent.putExtra("valgtOrd", "Hejsa");
            this.startActivity(intent);
        }
    }
}