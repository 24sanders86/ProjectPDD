package com.example.pdd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

public class FragmentFirstLevel extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_level, container, false);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton1);
        repeatButton.setOnClickListener(v -> {
            //repeat question
        });

        ImageButton nextButton = rootView.findViewById(R.id.nextButton1);
        nextButton.setEnabled(false);
        nextButton.setVisibility(rootView.INVISIBLE);

        ImageButton greenButton = rootView.findViewById(R.id.greenButton);
        greenButton.setOnClickListener(v -> {
            //sound
            nextButton.setEnabled(true);
            nextButton.setVisibility(rootView.VISIBLE);
        });

        nextButton.setOnClickListener(v -> {
            ft.replace(R.id.FirstLevelFragment, new FragmentSecondLevel());
            ft.commit();
        });


        ImageButton backButton = rootView.findViewById(R.id.backButton3);
        backButton.setOnClickListener(v -> {
            ft.replace(R.id.FirstLevelFragment, new StartFragment());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton3);
        helpButton.setOnClickListener(v -> (new FragmentHelpFirstLevel()).show(getFragmentManager(), "FragmentHelpFirstLevel"));

        return rootView;
    }
}