package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Level extends AppCompatActivity implements View.OnClickListener {

    Button videre;
    ListView listen;
    String spillerNavn;
    HentOrd hentOrd = new HentOrd();
    String ordet;



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

        hentFraDR();

        hentOrd.galgelogik.logStatus();

        String items[] = new String[]{"Pis", "prut", "lort"};

        //System.out.println("ordene: "+ hentOrd.galgelogik.muligeOrd);


    }



    private void hentFraDR() {
        backgroundThread.execute(() ->{
            try {
                hentOrd.hentOrdFraDr();
                uiThread.post(() -> {
                    System.out.println("Ord blev hentet fra DRs server");

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hentOrd.galgelogik.muligeOrd);

                    listen = (ListView) findViewById(R.id.list_view);
                    listen.setAdapter(adapter);
                    listen.setOnItemClickListener(messageClickHandler);

                });
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }


    private AdapterView.OnItemClickListener messageClickHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            System.out.println("der blev klikket på listen");
            System.out.println("der blev klikket på: " + hentOrd.galgelogik.muligeOrd.get(i));
            ordet = hentOrd.galgelogik.muligeOrd.get(i);
        }
    };


    @Override
    public void onClick(View view) {
        if(view == videre){
            Intent intent = new Intent(this, Spil.class);
            intent.putExtra("spillerNavn", spillerNavn);
            intent.putExtra("valgtOrd", ordet);
            this.startActivity(intent);
        }
    }
}