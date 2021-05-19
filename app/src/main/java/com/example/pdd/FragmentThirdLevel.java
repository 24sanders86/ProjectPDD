package com.example.pdd;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class FragmentThirdLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_third_level, container, false);

        ((MainActivity)getActivity()).changeLevel("3");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.road);
        question.start();

        MediaPlayer wellDone = MediaPlayer.create(getContext(),R.raw.roadclick);

        Button checkButton = rootView.findViewById(R.id.checkButton);

        ImageButton backButton = rootView.findViewById(R.id.backButton1);
        backButton.setOnClickListener(v -> {
            question.stop();
            checkButton.setVisibility(rootView.INVISIBLE);
            wellDone.stop();
            ft.replace(R.id.ThirdLevelFragment, new StartFragment());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton1);
        helpButton.setOnClickListener(v -> (new FragmentHelp()).show(getFragmentManager(), "FragmentHelp"));

        CheckBox perehod = rootView.findViewById(R.id.perehodCheckBox);
        CheckBox rightSign = rootView.findViewById(R.id.rightSignCheckBox);
        CheckBox noPerehod = rootView.findViewById(R.id.noPerehodCheckBox);
        CheckBox wrongSign = rootView.findViewById(R.id.wrongSignCheckBox);


        ImageButton nextButton = rootView.findViewById(R.id.nextButton3);
        nextButton.setVisibility(rootView.INVISIBLE);

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton3);
        repeatButton.setOnClickListener(v -> {
            question.start();
        });



        nextButton.setOnClickListener(v -> {
            wellDone.stop();
            question.stop();
            ft.replace(R.id.ThirdLevelFragment, new FragmentFourthLevel());
            ft.commit();
            checkButton.setVisibility(rootView.INVISIBLE);
        });



        checkButton.setOnClickListener(v -> {
            if (perehod.isChecked() && rightSign.isChecked()
                    && !noPerehod.isChecked() && !wrongSign.isChecked()) {
                wellDone.start();
                nextButton.setVisibility(rootView.VISIBLE);
            }
        });
        return rootView;
    }
}