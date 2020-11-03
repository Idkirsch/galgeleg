package com.example.galgeleg;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


public class highscore_frag extends Fragment {

    // sådan ser en preferencemanager ud i et fragment
    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity())

    TextView scores;
    SharedPreferences prefMan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         *
         *
         *
         * */

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return wv;
        View vw = inflater.inflate(R.layout.fragment_highscore_frag, container, false);

     //   String spillernavn = prefMan.getString("spillernavn", "ingen gemt tekst");

        scores = (TextView) vw.findViewById(R.id.highscore_frag);

        //scores.append("\n Hallo hallo "+ spillernavn);


        return vw;


    }
}