package com.example.galgeleg;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class highscore_frag extends Fragment {

    // sådan ser en preferencemanager ud i et fragment
    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity())

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return wv;
        return inflater.inflate(R.layout.fragment_highscore_frag, container, false);
    }
}