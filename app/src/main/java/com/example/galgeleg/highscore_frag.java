package com.example.galgeleg;

import android.content.Context;
import android.content.SharedPreferences;
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

import java.util.Map;


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



        Map<String,?> keys = prefMan.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
            //   Log.d("map values: ", entry.getKey() + " : "+ entry.getValue().toString());
            System.out.println("map values: " + entry.getKey() + " : " + entry.getValue().toString());
            prefData.append(entry.getKey() + " : " + entry.getValue() + "\n");

        }

        return vw;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}