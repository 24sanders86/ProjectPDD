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

import com.bumptech.glide.Glide;


public class FragmentSecondLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_second_level, container, false);

        ((MainActivity)getActivity()).changeLevel("2");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ImageButton button = rootView.findViewById(R.id.outOfWindow);
        ImageButton buttonIn = rootView.findViewById(R.id.inWindow);

        String url="https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/iz_okna_ready.png?alt=media&token=e598bd5a-e5d2-4314-a278-424454bf833d";
        Glide.with(FragmentSecondLevel.this).load(url).into(button);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/v_okne_man_ready.png?alt=media&token=9ddcec16-7f87-4dfe-9efb-e7a564a0506c";
        Glide.with(FragmentSecondLevel.this).load(url).into(buttonIn);

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.window);
        question.start();

        MediaPlayer wellDone = MediaPlayer.create(getContext(),R.raw.welldone2);

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton2);
        repeatButton.setOnClickListener(v -> {
            question.start();
        });


        ImageButton nextButton = rootView.findViewById(R.id.nextButton2);
        nextButton.setVisibility(rootView.INVISIBLE);


        button.setOnClickListener(v -> {
            wellDone.start();
            question.stop();
            button.setImageResource(R.drawable.v_okne_ready);
            nextButton.setVisibility(rootView.VISIBLE);
        });


        nextButton.setOnClickListener(v -> {
            question.stop();
            wellDone.stop();
            ft.replace(R.id.SecondLevelFragment, new FragmentThirdLevel());
            ft.commit();
        });


        ImageButton backButton = rootView.findViewById(R.id.backButton2);
        backButton.setOnClickListener(v -> {
            question.stop();
            wellDone.stop();
            ft.replace(R.id.SecondLevelFragment, new StartFragment());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton2);
        helpButton.setOnClickListener(v -> (new FragmentHelp()).show(getFragmentManager(), "FragmentHelp"));

        return rootView;
    }
}