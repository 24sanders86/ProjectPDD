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

public class FragmentSeventhLevel extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_last_levels, container, false);

        ((MainActivity)getActivity()).changeLevel("7");

        ImageButton nearBike = rootView.findViewById(R.id.topButton);
        ImageButton onBike = rootView.findViewById(R.id.bottomButton);
        ImageButton backButton = rootView.findViewById(R.id.backButton);
        ImageButton helpButton = rootView.findViewById(R.id.helpButton);
        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton);
        ImageButton nextButton = rootView.findViewById(R.id.nextButton);
        nextButton.setVisibility(rootView.INVISIBLE);

        MediaPlayer question = MediaPlayer.create(getContext(), R.raw.bike);
        question.start();

        MediaPlayer think = MediaPlayer.create(getContext(),R.raw.think);
        MediaPlayer rightAnswer = MediaPlayer.create(getContext(),R.raw.nearbike);

        String url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/near_bike_ready.jpg?alt=media&token=89bd873c-d5a6-4ef0-b787-616433a29a98";
        Glide.with(FragmentSeventhLevel.this).load(url).into(nearBike);

        url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/on_bike_ready.jpg?alt=media&token=4446bd26-bd2a-4771-afb1-ac1704f5ceda";
        Glide.with(FragmentSeventhLevel.this).load(url).into(onBike);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        nextButton.setOnClickListener(v -> {
            question.stop();
            think.stop();
            rightAnswer.stop();
            ft.replace(R.id.LastLevelsFragment, new EndFragment());
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

        onBike.setOnClickListener(v -> {
            think.start();
            question.stop();
            rightAnswer.stop();
        });

        nearBike.setOnClickListener(v -> {
            rightAnswer.start();
            think.stop();
            question.stop();
            nextButton.setVisibility(rootView.VISIBLE);
        });

        return rootView;
    }
}
