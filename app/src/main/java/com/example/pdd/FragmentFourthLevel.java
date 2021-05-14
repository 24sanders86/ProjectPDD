package com.example.pdd;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;


public class FragmentFourthLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fourth_level, container, false);

        ((MainActivity)getActivity()).changeLevel("4");

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.withwho);
        question.start();

        MediaPlayer wellDone = MediaPlayer.create(getContext(),R.raw.childwithadult);
        MediaPlayer wrong = MediaPlayer.create(getContext(),R.raw.childwithadultwrong);
        MediaPlayer alone = MediaPlayer.create(getContext(),R.raw.childalone);

        ImageButton backButton = rootView.findViewById(R.id.backButton4);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton4);
        repeatButton.setOnClickListener(v -> {
            question.start();
            wellDone.stop();
            wrong.stop();
            alone.stop();
        });

        backButton.setOnClickListener(v -> {
            question.stop();
            wellDone.stop();
            wrong.stop();
            alone.stop();
            ft.replace(R.id.FourthLevelFragment, new StartFragment());
        });

        ImageButton nextButton = rootView.findViewById(R.id.nextButton4);
        nextButton.setVisibility(rootView.INVISIBLE);

        ImageButton rightAnswer = rootView.findViewById(R.id.childWithAdultButton);
        rightAnswer.setOnClickListener(v -> {
            wellDone.start();
            wrong.stop();
            alone.stop();
            question.stop();
            nextButton.setVisibility(rootView.VISIBLE);
        });

        ImageButton wrongAnswer = rootView.findViewById(R.id.childWithAdultWrongButton);
        wrongAnswer.setOnClickListener(v -> {
            wrong.start();
            wellDone.stop();
            alone.stop();
            question.stop();
        });

        ImageButton alone1 = rootView.findViewById(R.id.childAloneButton);
        alone1.setOnClickListener(v -> {
            alone.start();
            wrong.start();
            wellDone.stop();
            question.stop();
        });

        ImageButton alone2 = rootView.findViewById(R.id.childWithChildButton);
        alone2.setOnClickListener(v -> {
            alone.start();
            wrong.start();
            wellDone.stop();
            question.stop();
        });

        String url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/child_with_child_ready.png?alt=media&token=d67edc07-16f7-4d4e-a2f2-2cfbb356def9";
        Glide.with(FragmentFourthLevel.this).load(url).into(alone2);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/child_with_adult_no_perehod_ready.png?alt=media&token=99899874-ccf1-4967-a9d3-22fa6118689b";
        Glide.with(FragmentFourthLevel.this).load(url).into(wrongAnswer);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/child_with_adult_ready.png?alt=media&token=5a2d6f38-cae5-421e-b606-24c16c7735d3";
        Glide.with(FragmentFourthLevel.this).load(url).into(rightAnswer);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/child_alone_ready.png?alt=media&token=994a3741-442b-40c4-b2e1-a76ab4444dd0";
        Glide.with(FragmentFourthLevel.this).load(url).into(alone1);

        url = "";

        nextButton.setOnClickListener(v -> {
            question.stop();
            wellDone.stop();
            wrong.stop();
            alone.stop();
            ft.replace(R.id.FourthLevelFragment, new FragmentFifthLevel());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton4);
        helpButton.setOnClickListener(v -> {
            (new FragmentHelp()).show(getFragmentManager(), "FragmentHelp");
        });

        return rootView;
    }
}