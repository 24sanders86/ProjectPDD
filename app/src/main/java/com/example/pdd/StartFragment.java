package com.example.pdd;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

import com.bumptech.glide.Glide;


public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);

        FragmentManager fm = requireActivity().getSupportFragmentManager();

        ImageView img = rootView.findViewById(R.id.butterfly);

        MediaPlayer backSong = MediaPlayer.create(getContext(), R.raw.background);
        backSong.start();
        backSong.setVolume(0,10);

        MediaPlayer privet = MediaPlayer.create(getContext(), R.raw.privet);
        privet.start();
        privet.setVolume(50,100);

        //загрузка изображения из firebase
        String url="https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/butterfly2_ready.png?alt=media&token=742c0537-b0e9-493d-9f35-94f6179940ad";
        Glide.with(StartFragment.this).load(url).into(img);

        ImageButton imageButton = rootView.findViewById(R.id.startButton);
        imageButton.setOnClickListener(v -> {
            privet.stop();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.startFragment, new FragmentFirstLevel());
            ft.addToBackStack(null);
            ft.commit();
        });

        int randomDuration = (new Random()).nextInt(2000 - 100 + 1) + 100;
        float randscale = (new Random()).nextFloat()* 0.5f+0.3f;

        final ScaleAnimation growanim = new ScaleAnimation(1.0f, randscale, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        growanim.setDuration(randomDuration);
        growanim.setRepeatCount(-1);
        growanim.setRepeatMode(Animation.REVERSE);
        growanim.setInterpolator(new AccelerateInterpolator());
        img.setAnimation(growanim);
        growanim.start();

        return rootView;
    }
}