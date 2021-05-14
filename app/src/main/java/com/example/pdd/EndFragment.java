package com.example.pdd;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class EndFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_end, container, false);

        MediaPlayer end = MediaPlayer.create(getContext(),R.raw.end);
        end.start();

        ImageView img = rootView.findViewById(R.id.imageView2);

        String url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/girl_ready.png?alt=media&token=18414c5c-d39c-4503-be60-f87dde18cb25";
        Glide.with(EndFragment.this).load(url).into(img);

        return rootView;
    }
}