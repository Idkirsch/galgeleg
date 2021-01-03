package com.example.galgeleg;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;


public class highscore_frag extends Fragment {

    // sådan ser en preferencemanager ud i et fragment
    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity())

    TextView scores, prefData;
    SharedPreferences prefMan;

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

        //scores = (TextView) vw.findViewById(R.id.highscore_frag);

        Context hostAct = getActivity();

        prefData = vw.findViewById(R.id.PrefData);

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
        String tempname = "";
        String tempname2 = "";
        String highname = "";

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


            //   Log.d("map values: ", entry.getKey() + " : "+ entry.getValue().toString());
//            System.out.println("map values: " + entry.getKey() + " : " + entry.getValue().toString());
//            prefData.append(entry.getKey() + " : " + entry.getValue() + "\n");
            prefData.setTextSize(24);
            prefData.setTextColor(Color.RED);

        }

        prefData.append(highname + " : "+ highest + "\n" + tempname + " : " + temp + "\n" + tempname2 + " : " + temp2);


        System.out.println(highest);
        return vw;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}