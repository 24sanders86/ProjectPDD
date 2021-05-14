package com.example.pdd;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private String k = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer backSong = MediaPlayer.create(getApplicationContext(), R.raw.background);
        backSong.start();
        backSong.setVolume(0,10);
    }

    public String getLevel(){
        return this.k;
    }

    public void changeLevel(String k1){
        this.k = k1;
    }
}