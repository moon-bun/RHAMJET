package com.RHAMJET.rhamscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openQRScanner = (Button) findViewById(R.id.launchQRCodeBtn);
        openQRScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQR = new Intent(getApplicationContext(), QRPage.class);
                startActivity(startQR);
            }
        });
    }
}