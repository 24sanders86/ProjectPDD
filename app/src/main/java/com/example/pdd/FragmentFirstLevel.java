package com.example.pdd;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentFirstLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_level, container, false);

        ((MainActivity)getActivity()).changeLevel("1");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.svetofor);
        question.start();

        MediaPlayer wellDone = MediaPlayer.create(getContext(),R.raw.svetoforclick);

        MediaPlayer pink = MediaPlayer.create(getContext(),R.raw.pink);

        MediaPlayer think = MediaPlayer.create(getContext(),R.raw.think);

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton1);
        repeatButton.setOnClickListener(v -> {
            question.start();
        });

        ImageButton nextButton = rootView.findViewById(R.id.nextButton1);
        nextButton.setVisibility(rootView.INVISIBLE);

        ImageButton pinkButton = rootView.findViewById(R.id.pinkButton);
        pinkButton.setOnClickListener(v -> {
            pink.start();
            question.stop();
        });

        ImageButton yellowButton = rootView.findViewById(R.id.yellowButton);
        yellowButton.setOnClickListener(v -> {
            think.start();
            question.stop();
        });

        ImageButton redButton = rootView.findViewById(R.id.redButton);
        redButton.setOnClickListener(v -> {
            think.start();
            question.stop();
        });

        ImageButton greenButton = rootView.findViewById(R.id.greenButton);
        greenButton.setOnClickListener(v -> {
            wellDone.start();
            question.stop();
            nextButton.setVisibility(rootView.VISIBLE);
        });

        nextButton.setOnClickListener(v -> {
            pink.stop();
            think.stop();
            question.stop();
            wellDone.stop();
            ft.replace(R.id.FirstLevelFragment, new FragmentSecondLevel());
            ft.commit();
        });


        ImageButton backButton = rootView.findViewById(R.id.backButton1);
        backButton.setOnClickListener(v -> {
            pink.stop();
            think.stop();
            question.stop();
            wellDone.stop();
            ft.replace(R.id.FirstLevelFragment, new StartFragment());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton1);
        helpButton.setOnClickListener(v -> (new FragmentHelp()).show(getFragmentManager(), "FragmentHelp"));

        return rootView;
    }
}