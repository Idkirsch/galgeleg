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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Level extends AppCompatActivity {

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
        Intent i = getIntent();
        spillerNavn = i.getStringExtra("spillerNavn");
        hentFraDR();
       // hentOrd.galgelogik.logStatus();

    }

    private void hentFraDR() {
        backgroundThread.execute(() -> {
            try {
                hentOrd.hentOrdFraDr();
                uiThread.post(() -> {
                    System.out.println("Ord blev hentet fra DRs server");


                    ArrayList<String> listen2 = hentOrd.galgelogik.muligeOrd;
//                    ArrayList<String> listen2 = hentOrd.galgelogik.muligeOrd;
                    //System.out.println("listen2 " + listen2);
                    
                    ArrayList<String> listenTrim = new ArrayList<>();
                    ArrayList<String> listenStars = new ArrayList<>();

                    for (String word : listen2) {


                       // System.out.println(word + " ");
                        if (word.length() > 4) {
                            // listen2.remove(word);
                         //   System.out.println(word + " : ");
                            String wordstar = new String();
                            for(int i = 0; i < word.length();i++){
                                wordstar = wordstar+"*";
                            }
                         //   System.out.println(wordstar);


                            listenTrim.add(word);
                            listenStars.add(wordstar);

                            
                        }
                    }


                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listenStars);

                    listen = (ListView) findViewById(R.id.list_view);
                    listen.setAdapter(adapter);
                    listen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            System.out.println("der blev klikket på: " + listenTrim.get(i));
                           // ordet = hentOrd.galgelogik.muligeOrd.get(i);
                            ordet = listenTrim.get(i);
                            Intent intent = new Intent(Level.this, Spil.class);
                            intent.putExtra("spillerNavn", spillerNavn);
                            intent.putExtra("valgtOrd", ordet);
                            startActivity(intent);
                        }
                    });

                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}