package com.example.osu727;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;

public class MainActivity extends AppCompatActivity {
    private ArFragment arFragment;
    private ModelRenderable modelRenderable;
    private String MODEL_URL="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}