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


public class FragmentSixthLevel extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_last_levels, container, false);

        ((MainActivity)getActivity()).changeLevel("6");

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.tramwai);
        question.start();

        MediaPlayer think = MediaPlayer.create(getContext(),R.raw.think);
        MediaPlayer rightAnswer = MediaPlayer.create(getContext(),R.raw.speredi);

        ImageButton left = rootView.findViewById(R.id.topButton);
        ImageButton right = rootView.findViewById(R.id.bottomButton);
        ImageButton backButton = rootView.findViewById(R.id.backButton);
        ImageButton helpButton = rootView.findViewById(R.id.helpButton);
        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton);
        ImageButton nextButton = rootView.findViewById(R.id.nextButton);
        nextButton.setVisibility(rootView.INVISIBLE);

        String url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/back_tramvai_ready.jpg?alt=media&token=6292fbf9-42f7-4821-9bd9-dbac7606f1a0";
        Glide.with(FragmentSixthLevel.this).load(url).into(left);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/pered_tramvai_ready.jpg?alt=media&token=11747893-5d0b-4b58-968a-55e559e29261";
        Glide.with(FragmentSixthLevel.this).load(url).into(right);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        nextButton.setOnClickListener(v -> {
            question.stop();
            think.stop();
            rightAnswer.stop();
            ft.replace(R.id.LastLevelsFragment, new FragmentSeventhLevel());
            ft.commit();
        });

        backButton.setOnClickListener(v -> {
            question.stop();
            think.stop();
            rightAnswer.stop();
            ft.replace(R.id.LastLevelsFragment, new StartFragment());
            ft.commit();
        });

        repeatButton.setOnClickListener(v -> {
            question.start();
            think.stop();
            rightAnswer.stop();
        });

        helpButton.setOnClickListener(v -> (new FragmentHelp()).show(getFragmentManager(), "FragmentHelp"));

        left.setOnClickListener(v -> {
            think.start();
            question.stop();
            rightAnswer.stop();
        });

        right.setOnClickListener(v -> {
            rightAnswer.start();
            think.stop();
            question.stop();
            nextButton.setVisibility(rootView.VISIBLE);
        });

        return rootView;
    }
}