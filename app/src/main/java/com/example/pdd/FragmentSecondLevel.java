package com.example.pdd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class FragmentSecondLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_second_level, container, false);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton2);
        repeatButton.setOnClickListener(v -> {
            //repeat question
        });

        ImageButton button = rootView.findViewById(R.id.outOfWindow);

        ImageButton nextButton = rootView.findViewById(R.id.nextButton2);
        nextButton.setEnabled(false);
        nextButton.setVisibility(rootView.INVISIBLE);


        button.setOnClickListener(v -> {
            button.setImageResource(R.drawable.v_okne_ready);
            nextButton.setEnabled(true);
            nextButton.setVisibility(rootView.VISIBLE);
        });


        nextButton.setOnClickListener(v -> {
            ft.replace(R.id.SecondLevelFragment, new FragmentThirdLevel());
            ft.commit();
        });


        ImageButton backButton = rootView.findViewById(R.id.backButton2);
        backButton.setOnClickListener(v -> {
            ft.replace(R.id.SecondLevelFragment, new StartFragment());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton2);
        helpButton.setOnClickListener(v -> (new FragmentHelpSecondLevel()).show(getFragmentManager(), "FragmentHelpSecondLevel"));
        

/*Handler handler = new Handler();
        handler.postDelayed(() -> {}, 5000);*/

        return rootView;
    }
}