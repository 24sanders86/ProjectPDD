package com.example.pdd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentFourthLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fourth_level, container, false);

        ImageButton backButton = rootView.findViewById(R.id.backButton4);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton4);
        repeatButton.setOnClickListener(v -> {
            //repeat question
        });

        backButton.setOnClickListener(v -> {
            ft.replace(R.id.FourthLevelFragment, new StartFragment());
        });

        ImageButton nextButton = rootView.findViewById(R.id.nextButton4);
        nextButton.setEnabled(false);
        nextButton.setVisibility(rootView.INVISIBLE);

        ImageButton rightAnswer = rootView.findViewById(R.id.childWithAdultButton);
        rightAnswer.setOnClickListener(v -> {
            nextButton.setEnabled(true);
            nextButton.setVisibility(rootView.VISIBLE);
        });

        nextButton.setOnClickListener(v -> {
            ft.replace(R.id.FourthLevelFragment, new FragmentFifthLevel());
            ft.commit();
        });

        return rootView;
    }
}