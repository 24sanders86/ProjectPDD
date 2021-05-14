package com.example.pdd;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class FragmentHelp extends DialogFragment {

    private String k = "1";
    private String url = " ";

    public String chooseLevel(){

        k = ((MainActivity)getActivity()).getLevel();

        switch(k){
            case("1"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/first_level_help_ready.jpg?alt=media&token=afa4c8a5-2006-45df-9eba-58df8c558260";
                break;
            case ("2"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/help_second_level_ready.png?alt=media&token=8390d2b3-dc5e-4f5a-81fd-eb471392712d";
                break;
            case("3"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/help_third_level_ready.jpg?alt=media&token=c7e19a3d-1e36-4a9b-852f-07f7f36ea3dc";
                break;
            case("4"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/help_fourth_level_ready.jpg?alt=media&token=e12307af-ab34-4bc2-8017-74a4c2d39639";
                break;
            case ("5"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/help_sixth_level_ready.jpg?alt=media&token=9f4349c9-d9d7-45c8-ab2e-63445b4c4da3";
                break;
            case("6"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/help_seventh_level_ready.jpg?alt=media&token=bb6b685e-c86c-4544-b270-2dc6d88c383b";
                break;
            case("7"):
                url = "https://firebasestorage.googleapis.com/v0/b/projectpdd-61788.appspot.com/o/help_fifth_level_ready.jpg?alt=media&token=a4677ca9-792f-45c9-bdcb-be870c1d9e0e";
                break;
        }
        return url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_help, container, false);

        String url = chooseLevel();

        ImageView img = rootView.findViewById(R.id.imageView);
        Glide.with(FragmentHelp.this).load(url).into(img);

        ImageButton backButton = rootView.findViewById(R.id.backHelpButton);
        backButton.setOnClickListener(v -> {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.remove(this).commit();
        });

        Log.d("level", k);

        return rootView;
    }
}