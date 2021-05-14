package com.example.pdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private String k = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getLevel(){
        return this.k;
    }

    public void changeLevel(String k1){
        this.k = k1;
    }
}