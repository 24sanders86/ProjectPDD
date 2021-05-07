package com.example.pdd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class FragmentThirdLevel extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_third_level, container, false);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ImageButton backButton = rootView.findViewById(R.id.backButton3);
        backButton.setOnClickListener(v -> {
            ft.replace(R.id.ThirdLevelFragment, new StartFragment());
            ft.commit();
        });

        ImageButton helpButton = rootView.findViewById(R.id.helpButton3);
        helpButton.setOnClickListener(v -> (new FragmentHelpThirdLevel()).show(getFragmentManager(), "FragmentHelpThirdLevel"));

        CheckBox perehod = rootView.findViewById(R.id.perehodCheckBox);
        CheckBox rightSign = rootView.findViewById(R.id.rightSignCheckBox);
        CheckBox noPerehod = rootView.findViewById(R.id.noPerehodCheckBox);
        CheckBox wrongSign = rootView.findViewById(R.id.wrongSignCheckBox);

        ImageButton nextButton = rootView.findViewById(R.id.nextButton3);
        nextButton.setEnabled(false);
        nextButton.setVisibility(rootView.INVISIBLE);

        ImageButton repeatButton = rootView.findViewById(R.id.repeatButton3);
        repeatButton.setOnClickListener(v -> {
            //repeat question
        });

        Button checkButton = rootView.findViewById(R.id.checkButton);

        nextButton.setOnClickListener(v -> {
            ft.replace(R.id.ThirdLevelFragment, new FragmentFourthLevel());
            ft.commit();
            checkButton.setVisibility(rootView.INVISIBLE);
        });



        checkButton.setOnClickListener(v -> {
            if (perehod.isChecked() && rightSign.isChecked()
                    && !noPerehod.isChecked() && !wrongSign.isChecked()) {
                //sound
                nextButton.setEnabled(true);
                nextButton.setVisibility(rootView.VISIBLE);
            }
        });
        return rootView;
    }
}