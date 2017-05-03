package com.yclients.n63033.beatysalon.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yclients.n63033.beatysalon.R;


public class SeanceTimesFragment extends Fragment {

    public SeanceTimesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seance_times,container,false);
        return view;
    }
}
