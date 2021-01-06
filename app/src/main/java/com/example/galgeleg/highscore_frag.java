package com.example.galgeleg;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;


public class highscore_frag extends Fragment {

    // sådan ser en preferencemanager ud i et fragment
    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity())

     TextView scores;
     SharedPreferences prefMan;
//    String names[] = new String[3];
//    int points[] = new int[3];
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    //required empty constructor
    public highscore_frag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.fragment_highscore_frag, container, false);


        ArrayList<RecyclerItem> recyclerList = new ArrayList<>();

        //scores = (TextView) vw.findViewById(R.id.highscore_frag);

        Context hostAct = getActivity();


        prefMan = hostAct.getSharedPreferences("GemDataTest", Context.MODE_PRIVATE);
        String spillernavn = prefMan.getString("spillernavn1", "ingen gemt tekst");
        System.out.println("prefman all: "+prefMan.getAll());
        System.out.println("Det første spillernavn: "+ spillernavn);


       // SortedMap<String,String> keys = new TreeMap<String, String>(prefMan.getAll());
        //= prefMan.getAll();
       // Map<String,?> keys = prefMan.getAll();
       // keys = (SortedMap<String, String>) prefMan.getAll();

         Map<String,?> map =  prefMan.getAll();

//         Stream<Map.Entry<String,String>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());

        System.out.println(map);
        int highest = 0;
        int temp = 0;
        int temp2 = 0;
        String tempname = new String();
        String tempname2 = new String();
        String highname = new String();
        String text = " point";

        for(Map.Entry<String,?> entry : map.entrySet()){


            for(Map.Entry<String,?> entry1 : map.entrySet()) {
                if (Integer.valueOf((String) entry1.getValue()) > highest) {
                    System.out.println("større end highest");
                    highest = Integer.valueOf((String) entry1.getValue());
                }
            }

            for(Map.Entry<String,?> entry2 : map.entrySet()) {
                if (Integer.valueOf((String) entry2.getValue()) < highest && Integer.valueOf((String) entry2.getValue()) > temp) {
                    temp = Integer.valueOf((String) entry2.getValue());
                }
            }


            for(Map.Entry<String,?> entry3 : map.entrySet()) {
                if (Integer.valueOf((String) entry3.getValue()) < temp && Integer.valueOf((String) entry3.getValue()) > temp2) {
                    temp2 = Integer.valueOf((String) entry3.getValue());
                }
            }


            if(Integer.valueOf((String) entry.getValue()) == temp){
                tempname = entry.getKey();
            }

            if(Integer.valueOf((String) entry.getValue()) == highest){
                highname = entry.getKey();
            }


            if(Integer.valueOf((String) entry.getValue()) == temp2){
                tempname2 = entry.getKey();
            }


        }



        recyclerList.add(new RecyclerItem(R.drawable.first, highname,highest,text));
       // recyclerList.add(new RecyclerItem(R.drawable.ic_halfsun, tempname,temp,text));
        recyclerList.add(new RecyclerItem(R.drawable.second, tempname,temp,text));
        recyclerList.add(new RecyclerItem(R.drawable.third, tempname2,temp2,text));


        recyclerView = vw.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(hostAct);
        adapter = new RecyclerAdapter(recyclerList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return vw;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}