package com.example.pdd;

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


public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);

        FragmentManager fm = requireActivity().getSupportFragmentManager();

        ImageButton imageButton = rootView.findViewById(R.id.startButton);
        imageButton.setOnClickListener(v -> {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.startFragment, new FragmentFirstLevel());
            ft.addToBackStack(null);
            ft.commit();
        });

        ImageView img = rootView.findViewById(R.id.imageView5);

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

        //светоотражатели право лево смотреть знаки ремонта самокат велик везти ря дом бегом не переходить ток пешком
    }
}