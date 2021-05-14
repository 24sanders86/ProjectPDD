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


public class FragmentFifthLevel extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_last_levels, container, false);

        ((MainActivity)getActivity()).changeLevel("5");

        ImageButton backButton = rootView.findViewById(R.id.backButton);
        ImageButton helpButton = rootView.findViewById(R.id.helpButton);
        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton);
        ImageButton roadButton = rootView.findViewById(R.id.topButton);
        ImageButton peshehodButton = rootView.findViewById(R.id.bottomButton);
        ImageButton nextButton = rootView.findViewById(R.id.nextButton);
        nextButton.setVisibility(rootView.INVISIBLE);

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.peshehodi);
        question.start();
        MediaPlayer wrong = MediaPlayer.create(getContext(), R.raw.think);
        MediaPlayer rightAnswer = MediaPlayer.create(getContext(),R.raw.peshehodianswer);

        String url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/road_ready.jpg?alt=media&token=d1463b5d-114f-48ac-a8d2-fd1f14b4fceb";
        Glide.with(FragmentFifthLevel.this).load(url).into(roadButton);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/peshehodnay_ready.jpg?alt=media&token=5ae4cdb6-4f69-43e5-8351-aefc74972328";
        Glide.with(FragmentFifthLevel.this).load(url).into(peshehodButton);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        roadButton.setOnClickListener(v -> {
            question.stop();
            rightAnswer.stop();
            wrong.start();
        });

        peshehodButton.setOnClickListener(v -> {
            rightAnswer.start();
            question.stop();
            wrong.stop();
            nextButton.setVisibility(rootView.VISIBLE);
        });

        nextButton.setOnClickListener(v -> {
            question.stop();
            wrong.stop();
            rightAnswer.stop();
            ft.replace(R.id.LastLevelsFragment, new FragmentSixthLevel());
            ft.commit();
        });

        backButton.setOnClickListener(v -> {
            question.stop();
            wrong.stop();
            rightAnswer.stop();
            ft.replace(R.id.LastLevelsFragment, new StartFragment());
            ft.commit();
        });

        repeatButton.setOnClickListener(v -> {
            question.start();
            wrong.stop();
            rightAnswer.stop();
        });

        helpButton.setOnClickListener(v -> (new FragmentHelp()).show(getFragmentManager(), "FragmentHelp"));


        return rootView;
    }
}