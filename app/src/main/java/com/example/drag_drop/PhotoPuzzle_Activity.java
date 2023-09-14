package com.example.drag_drop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class PhotoPuzzle_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_puzzle);
        RelativeLayout selectImg;
        ImageView imageView;
        Button startBtn;

        ImageView[] img = new ImageView[9];
        LinearLayout[] linear = new LinearLayout[9];
        List<Pictures> imgList = new ArrayList<>();


        setContentView(R.layout.activity_main);


    }
}